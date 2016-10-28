package com.sap.imdb.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.User;
import com.sap.imdb.service.UserService;
import com.sap.imdb.validations.ImdbValidate;

@RequestMapping(value="/signup")
@Controller
public class SignUpController {
	
	@Resource
	private UserService userService;
	@Resource
	private ImdbValidate ImdbValidate;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String makeReservationForm(Model model,@RequestParam(value = "error", required = false) String error){
		model.addAttribute("user",new User());
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		return "/signupViews/signup";
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public String signUp(@Valid User user,Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception{
		try{
			ImdbValidate.passwordMatch(user, request.getParameter("pass2"));
			userService.saveUser(user);
			model.addAttribute("success", "User registration complete!");
			return "/internalViews/success";
		}catch (Exception e){
			String message = e.getMessage();
			// TODO Auto-generated catch block
			model.addAttribute("error", message);
			return "/signupViews/signup";
		}
	}
}
