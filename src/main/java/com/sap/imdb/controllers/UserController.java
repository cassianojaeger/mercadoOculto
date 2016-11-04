package com.sap.imdb.controllers;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.Movie;
import com.sap.imdb.service.MovieService;
import com.sap.imdb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	UserService userService;
	@Resource
	MovieService movieService;
	
	@RequestMapping(value="/saveRemoveWishlist/{movieId}", method = RequestMethod.POST)
	public String wishlist(@PathVariable("movieId") Integer movieId, Principal principal, 
			RedirectAttributes redirectAttributes){		
		String message = userService.saveRemoveWishlist(movieId, principal);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/home/info/"+movieId;
	}
	
	@RequestMapping("/wishlist")
	public String showWishlist(Principal principal, Model model){
		List<Movie> wishlist = userService.showWishlist(principal);
		model.addAttribute("userMovies", wishlist);
		return "/userViews/wishlist";
	}
	
	@RequestMapping(value="/comment/{movieId}", method = RequestMethod.POST)
	public String comment(@PathVariable("movieId") Integer movieId, HttpServletRequest req, Principal principal){
		String comment = req.getParameter("comment");
		movieService.saveComment(principal, comment, movieId);
		return "redirect:/home/info/"+movieId;
	}
}
