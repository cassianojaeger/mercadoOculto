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

import com.sap.imdb.model.User;
import com.sap.imdb.service.UserService;

@RequestMapping(value="/signup")
@Controller
public class SignUpController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String signUp(Model model){
		model.addAttribute("user",new User());
		return "/signupViews/signup";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String makeReservationForm(@Valid User user, 
			BindingResult bindingResult,Model model, 
			RedirectAttributes redirectAttributes) throws Exception{
		if(bindingResult.hasErrors()){
			return "/signupViews/signup";
		}
			userService.saveUser(user);
			return "redirect:/signup/success";
	}
	
	@RequestMapping(value="/success", method = RequestMethod.GET)
	public String successRegistration(Model model){
		model.addAttribute("success", "User registration complete!");
		return "/signupViews/success";
	}
	
	@RequestMapping(value="/userlist", method = RequestMethod.GET)
	public String userList(Model model){
		List<User> users = userService.getListUser();
		model.addAttribute("users", users);
		return "/signupViews/userList";
	}
	
	
	
}
