package com.sap.imdb.controllers;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.Product;
import com.sap.imdb.model.User;
import com.sap.imdb.service.ProductService;
import com.sap.imdb.service.UserService;
import com.sap.imdb.validations.ImdbValidate;


@Controller
@RequestMapping(value = "/moderator-console")
public class AdmController
{

	@Resource
	private UserService userService;
	@Resource
	private ImdbValidate imdbValidate;
	@Resource
	private ProductService productService;


	@RequestMapping(value = "/view-all-products", method = RequestMethod.GET)
	public String manageAllProducts(final Product product, final Model model)
	{
		final List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "/adminViews/allProducts";
	}

	@RequestMapping(value = "/view-all-users", method = RequestMethod.GET)
	public String manageAllUsers(final User user, final Model model)
	{
		final List<User> users = userService.getListUser();
		model.addAttribute("users", users);
		return "/adminViews/allUsers";
	}

	@RequestMapping(value = "/delete-user/{id}", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") final Integer id, final RedirectAttributes redirectAttributes,
			final Principal principal)
	{
		final User user = userService.getUser(id);
		try
		{
			userService.removeUser(user, principal);
			redirectAttributes.addFlashAttribute("deleteError", "Usuario deletado");
		}
		catch (final Exception e)
		{
			final String message = e.getMessage();
			redirectAttributes.addFlashAttribute("deleteError", message);
		}
		return "redirect:/moderator-console/view-all-users";
	}

	@RequestMapping(value = "/delete-product/{id}", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable("id") final Integer id, final RedirectAttributes redirectAttributes)
	{
		final Product product = productService.getProduct(id);
		try
		{
			productService.removeProduct(product);
			redirectAttributes.addFlashAttribute("deleteError", "Produto deletado");
		}
		catch (final Exception e)
		{
			redirectAttributes.addFlashAttribute("deleteError", "Produto não deletado");
		}
		return "redirect:/moderator-console/view-all-products";
	}

	/*
	 * Mudar isso para edit de perfil de usuário!
	 *
	 * @RequestMapping(value = "/editMovie/{id}", method = RequestMethod.GET) public String editMovie(@PathVariable("id")
	 * final Integer id, final Model model) { final Movie movie = movieService.getMovie(id); model.addAttribute("movie",
	 * movie); model.addAttribute("genreList", Genre.values()); return "/adminViews/editMovie"; }
	 *
	 * @RequestMapping(value = "/editMovie/{id}", method = RequestMethod.POST) public String editMovie(final
	 * MultipartFile file, @Valid final Movie movie, final BindingResult bindingResult, final Model model, final
	 * RedirectAttributes redirectAttributes) throws Exception { if (bindingResult.hasErrors()) {
	 * model.addAttribute("genreList", Genre.values()); return "/adminViews/editMovie"; } try {
	 * imdbValidate.validateThumbnail(file); movieService.uploadThumbnail(file, movie); } catch (final Exception re) {
	 * //bindingResult.rejectValue("thumbnail", "message0", re.getMessage()); model.addAttribute("genreList",
	 * Genre.values()); return "/adminViews/editMovie"; } movieService.updateMovie(movie); return "redirect:/home"; }
	 */
}
