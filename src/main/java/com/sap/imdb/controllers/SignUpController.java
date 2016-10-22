package com.sap.imdb.controllers;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.User;
import com.sap.imdb.service.UserService;


@Controller
public class SignUpController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signUp(Model model){
		model.addAttribute("user",new User());
		return "signup";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String makeReservationForm(@Valid User user, 
			BindingResult bindingResult,Model model, 
			RedirectAttributes redirectAttributes) throws Exception{
		if(bindingResult.hasErrors()){
			return "signup";
		}
			userService.saveUser(user);
			return "redirect:/signup/success";
	}
	
	@RequestMapping(value="/signup/success", method = RequestMethod.GET)
	public String successRegistration(Model model){
		model.addAttribute("success", "User registration complete!");
		return "success";
	}
	
	
	
}
