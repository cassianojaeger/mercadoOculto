package com.sap.imdb.controllers;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sap.imdb.model.Movie;
import com.sap.imdb.service.MovieService;

@RequestMapping(value="/home")
@Controller
public class HomeController {
	
	@Resource
	private MovieService movieService;
	
	@RequestMapping("/")
	public String movieList(Model model){
		List<Movie> movies = movieService.getListMovie();
		model.addAttribute("movies", movies);
		return "/homeViews/movielist";
	}
	
}