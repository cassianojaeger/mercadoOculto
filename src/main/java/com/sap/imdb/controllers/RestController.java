	package com.sap.imdb.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sap.imdb.model.Movie;
import com.sap.imdb.model.User;
import com.sap.imdb.service.MovieService;
import com.sap.imdb.service.UserService;

@Controller
@RequestMapping("/rest")
public class RestController {
	
	@Resource
	MovieService movieService;
	@Resource
	UserService userService;
	
	@ResponseBody
	@RequestMapping("/restAllMovies")
	public List<Movie> requestJsonMovies() {
		return movieService.getListMovie();
	}
	
	@ResponseBody
	@RequestMapping("/restAllMovies/{id}")
	public Movie requestJsonMovieById(@PathVariable("id") Integer id) {
		return movieService.getMovie(id);
	}

	@ResponseBody
	@RequestMapping("/restAllUsers")
	public List<User> requestJsonUsers() {
		return userService.getListUser();
	}

	@ResponseBody
	@RequestMapping("/restAllUsers/{id}")
	public User requestJsonUsers(@PathVariable("id") Integer id) {
		return userService.getUser(id);
	}
}
