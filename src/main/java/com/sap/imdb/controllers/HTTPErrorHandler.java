package com.sap.imdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTTPErrorHandler {
	
	@RequestMapping("/403")
	public String accessDenied(){		
		return "internalViews/403";
	}
	
    @RequestMapping(value="/404")
    public String error404() {
        return "/internalViews/404";
    }
    
    @RequestMapping(value="/405")
    public String error405() {
        return "/internalViews/405";
    }
}

