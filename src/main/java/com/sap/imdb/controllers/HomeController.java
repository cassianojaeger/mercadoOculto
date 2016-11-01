package com.sap.imdb.controllers;



import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sap.imdb.model.Movie;
import com.sap.imdb.service.MovieService;

@RequestMapping(value="/home")
@Controller
public class HomeController {
	
	@Resource
	private MovieService movieService;
	
	@RequestMapping("")
	public String movieList(Model model, Principal principal){
		List<Movie> movies = movieService.getListMovie();
		model.addAttribute("movies", movies);
		String name = principal.getName();
		model.addAttribute("username", name);
		return "/homeViews/movielist";
	}
	
	@RequestMapping("/info/{id}")
	public String getMovieInfo(@PathVariable("id") Integer id, Model model ){
		Movie movie = movieService.getMovie(id);
		model.addAttribute("movie", movie);
		return "/homeViews/movieInfo";
	}
	
	@RequestMapping(value="/filterByName", method = RequestMethod.GET)
	public String filterByName(@RequestParam("filter") String filter, Model model){		
		model.addAttribute("movies", movieService.getMoviesByTitle(filter));
		return "/homeViews/movie-template";
	}
	
}
