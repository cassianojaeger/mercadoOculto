package com.sap.imdb.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.User;
import com.sap.imdb.model.UserTypes;
import com.sap.imdb.service.UserService;
import com.sap.imdb.validations.ImdbValidate;


@RequestMapping(value = "/signup")
@Controller
public class SignUpController
{

	@Resource
	private UserService userService;
	@Resource
	private ImdbValidate imdbValidate;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String signUp(final User user, final Model model)
	{
		CommonModelBindings(model);
		return "/signupViews/signup";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String signUp(@Valid final User user, final Model model, final RedirectAttributes redirectAttributes,
			final HttpServletRequest request) throws Exception
	{
		try
		{
			imdbValidate.passwordMatch(user, request.getParameter("pass2"));
			userService.saveUser(user);
			model.addAttribute("success", "User registration complete!");
			return "/internalViews/success";
		}
		catch (final Exception e)
		{
			final String message = e.getMessage();
			// TODO Auto-generated catch block
			model.addAttribute("error", message);
			CommonModelBindings(model);
			return "/signupViews/signup";
		}
	}

	private void CommonModelBindings(final Model model)
	{
		model.addAttribute("userTypeList", UserTypes.values());
	}
}
