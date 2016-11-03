package com.sap.imdb.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.Genre;
import com.sap.imdb.model.Movie;
import com.sap.imdb.service.MovieService;
import com.sap.imdb.service.UserService;
import com.sap.imdb.validations.ImdbValidate;

@Controller
@RequestMapping("/admconsole")
public class AdmController {

	@Resource
	private UserService userService;
	@Resource
	private MovieService movieService;
	@Resource
	private ImdbValidate imdbValidate;

	@RequestMapping(value = "/registermovie", method = RequestMethod.GET)
	public String registerMovie(Movie movie, Model model) {
		model.addAttribute("genreList", Genre.values());
		return "/adminViews/newMovie";
	}

	@RequestMapping(value = "/registermovie", method = RequestMethod.POST)
	public String registerMovie(MultipartFile file, @Valid Movie movie, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) throws Exception {
		if (bindingResult.hasErrors()) {
			model.addAttribute("genreList", Genre.values());
			return "/adminViews/newMovie";
		}		
		try {
			imdbValidate.validateThumbnail(file);
			movieService.uploadThumbnail(file, movie);			
		} catch (Exception re) {
			bindingResult.rejectValue("thumbnail", "message0", re.getMessage());
			model.addAttribute("genreList", Genre.values());
			return "/adminViews/newMovie";
		}
		movieService.saveMovie(movie);
		model.addAttribute("success", "Movie registration complete!");
		return "/internalViews/success";
	}

	@RequestMapping(value = "/editMovie/{id}", method = RequestMethod.GET)
	public String editMovie(@PathVariable("id") Integer id, Model model) {
		Movie movie = movieService.getMovie(id);
		model.addAttribute("movie", movie);
		model.addAttribute("genreList", Genre.values());
		return "/adminViews/editMovie";
	}

	@RequestMapping(value = "/editMovie/{id}", method = RequestMethod.POST)
	public String editMovie(MultipartFile file, @Valid Movie movie, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) throws Exception {
		if (bindingResult.hasErrors()) {
			model.addAttribute("genreList", Genre.values());
			return "/adminViews/editMovie";
		}
		try {
			imdbValidate.validateThumbnail(file);
			movieService.uploadThumbnail(file, movie);			
		} catch (Exception re) {
			//bindingResult.rejectValue("thumbnail", "message0", re.getMessage());
			model.addAttribute("genreList", Genre.values());
			return "/adminViews/editMovie";
		}
		movieService.updateMovie(movie);
		return "redirect:/home";
	}

	@RequestMapping(value = "/deleteMovie/{id}", method = RequestMethod.POST)
	public String deleteMovie(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		Movie movie = movieService.getMovie(id);
		try{
			movieService.removeMovie(movie);
			movieService.deleteThumbnail(movie);
			redirectAttributes.addFlashAttribute("deleteError", "Filme deletado");
		}catch(Exception e){
			redirectAttributes.addFlashAttribute("deleteError", "Filme não pode ser deletado pois está atrelado a uma wishlist");
		}		
		return "redirect:/home";
	}
}
