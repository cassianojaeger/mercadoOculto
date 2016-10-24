package com.sap.imdb.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.Movie;
import com.sap.imdb.model.User;
import com.sap.imdb.service.MovieService;
import com.sap.imdb.service.UserService;
@Controller
@RequestMapping("/admin")
public class AdmController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private MovieService movieService;
	
	//Vai virar admconsole/userlist a request mapping
	//na controler de adm
	@RequestMapping(value="/userlist", method = RequestMethod.GET)
	public String userList(Model model){
		List<User> users = userService.getListUser();
		model.addAttribute("users", users);
		return "/adminViews/userList";
	}
	
	@RequestMapping(value="/registermovie", method = RequestMethod.GET)
	public String registerMovie(Model model){
		model.addAttribute("movie",new Movie());
		return "/adminViews/newMovie";
	}
	
	@RequestMapping(value="/registermovie", method = RequestMethod.POST)
	public String registerMovie(@Valid Movie movie, 
			BindingResult bindingResult,Model model, 
			RedirectAttributes redirectAttributes) throws Exception{
		if(bindingResult.hasErrors()){
			return "/admin/registermovie";
		}
		movieService.saveMovie(movie);
		model.addAttribute("success", "Movie registration complete!");
		return "/adminViews/success";
	}
}
