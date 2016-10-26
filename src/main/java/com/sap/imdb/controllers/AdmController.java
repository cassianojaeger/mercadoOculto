package com.sap.imdb.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.Genre;
import com.sap.imdb.model.Movie;
import com.sap.imdb.service.MovieService;
import com.sap.imdb.service.UserService;
@Controller
@RequestMapping("/admconsole")
public class AdmController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private MovieService movieService;
	@RequestMapping(value="/movielist", method = RequestMethod.GET)
	public String userList(Model model){
		List<Movie> movies = movieService.getListMovie();
		model.addAttribute("movies", movies);
		return "/adminViews/movieConsole";
	}
	
	@RequestMapping(value="/registermovie", method = RequestMethod.GET)
	public ModelAndView registerMovie(Movie movie){
		ModelAndView model = new ModelAndView("/adminViews/newMovie");
		model.addObject("genreList", Genre.values());			
		return model;
	}
	
	@RequestMapping(value="/registermovie", method = RequestMethod.POST)
	public ModelAndView registerMovie(@Valid Movie movie, 
			BindingResult bindingResult,Model model, 
			RedirectAttributes redirectAttributes) throws Exception{
		if(bindingResult.hasErrors()){				
			return registerMovie(movie);
		}
		movieService.saveMovie(movie);
		ModelAndView model2 = new ModelAndView("/adminViews/success");
		model2.addObject("success", "Movie registration complete!");
		return model2;
	}
	
	@RequestMapping(value="/editMovie/{id}", method = RequestMethod.GET)
	public ModelAndView editMovie(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("/adminViews/editMovie");
		Movie movie = movieService.getMovie(id);
		modelAndView.addObject("movie", movie);		
		modelAndView.addObject("genreList", Genre.values());
		return modelAndView;
	}
	
	@RequestMapping(value="/editMovie/{id}", method = RequestMethod.POST)
	public ModelAndView editMovie(@Valid Movie movie, BindingResult bindingResult, 
			Model model, RedirectAttributes redirectAttributes) throws Exception{	
		if(bindingResult.hasErrors()){
			return editMovie(movie.getId());
		}		
		movieService.updateMovie(movie);						
		return new ModelAndView("redirect:/admconsole/movielist");		
	}
	
	@RequestMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable("id") Integer id){
		Movie movie = movieService.getMovie(id);
		movieService.removeMovie(movie);
		return "redirect:/admconsole/movielist";		
	}
}
