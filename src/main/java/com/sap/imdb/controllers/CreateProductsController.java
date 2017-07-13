package com.sap.imdb.controllers;

import java.security.Principal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.service.ProductService;
import com.sap.imdb.validations.ImdbValidate;


@RequestMapping(value = "/create-products")
@Controller
public class CreateProductsController
{

	@Resource
	private ProductService productService;

	@Resource
	private ImdbValidate imdbValidate;

	@RequestMapping(value = "/magicItem", method = RequestMethod.GET)
	public String createMagicItem(final MagicItems magicItem, final Model model)
	{
		return "/createProductViews/createMagicItem";
	}

	@RequestMapping(value = "/magicItem", method = RequestMethod.POST)
	public String createMagicItem(final MultipartFile file, @Valid final MagicItems magicItem, final BindingResult bindingResult,
			final Model model, final RedirectAttributes redirectAttributes, final Principal principal, final HttpServletRequest req)
			throws Exception
	{
		if (bindingResult.hasErrors())
		{
			return "/createProductViews/createMagicItem";
		}
		try
		{
			imdbValidate.validateThumbnail(file);
			productService.uploadThumbnail(file, magicItem, req.getServletContext().getRealPath(""));
			imdbValidate.validateMagicItem(magicItem);
		}
		catch (final Exception re)
		{
			bindingResult.rejectValue("thumbnail", "message0", re.getMessage());
			final String message = re.getMessage();
			model.addAttribute("error", message);
			return "/createProductViews/createMagicItem";
		}
		productService.saveMagicItem(magicItem, principal);
		model.addAttribute("success", "Registro de item mágico completo!");
		return "/internalViews/success";
	}


	@RequestMapping(value = "/magicService", method = RequestMethod.GET)
	public String createMagicService(final MagicServices magicService, final Model model)
	{
		return "/createProductViews/createMagicService";
	}

	@RequestMapping(value = "/magicService", method = RequestMethod.POST)
	public String createMagicService(final MultipartFile file, @Valid final MagicServices magicService,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes,
			final Principal principal, final HttpServletRequest req) throws Exception
	{
		if (bindingResult.hasErrors())
		{
			return "/createProductViews/createMagicService";
		}
		try
		{
			imdbValidate.validateThumbnail(file);
			productService.uploadThumbnail(file, magicService, req.getServletContext().getRealPath(""));
			imdbValidate.validateMagicService(magicService);
		}
		catch (final Exception re)
		{
			bindingResult.rejectValue("thumbnail", "message0", re.getMessage());
			final String message = re.getMessage();
			model.addAttribute("error", message);
			return "/createProductViews/createMagicService";
		}
		productService.saveMagicService(magicService, principal);
		model.addAttribute("success", "Registro de serviço mágico completo!");
		return "/internalViews/success";
	}
}
