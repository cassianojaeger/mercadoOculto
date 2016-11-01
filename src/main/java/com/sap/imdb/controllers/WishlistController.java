package com.sap.imdb.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class WishlistController {
	
	@RequestMapping("/wishlist")
	public String wishlist(Principal principal, Model model){		
		String name = principal.getName();
		model.addAttribute("username", name);
		return "/teste/teste.jsp";
	}
}
