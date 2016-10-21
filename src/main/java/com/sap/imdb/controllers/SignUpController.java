package com.sap.imdb.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String signUp(Model model){
		model.addAttribute("signup",new User());
		return "signup";
	}
}
