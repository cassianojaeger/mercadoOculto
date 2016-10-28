package com.sap.imdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InternalControler {
	
	@RequestMapping("/403")
	public String accessDenied(){		
		return "internalViews/403";
	}
}

