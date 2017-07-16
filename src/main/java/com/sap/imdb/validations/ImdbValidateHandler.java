package com.sap.imdb.validations;

import javax.annotation.Resource;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Product;
import com.sap.imdb.model.User;


@Component(value = "imdbValidate")
public class ImdbValidateHandler implements ImdbValidate
{

	@Resource
	private UserDao userDao;

	@Override
	public void validateSignUp(final User user) throws Exception
	{
		validateNullForm(user);
		nameOnlyLetters(user);
		usernameOnlyLettersNumber(user);
		emailPatternValidation(user);
		passwordPatternValidation(user);
		alreadyHasUsername(user);
	}

	@Override
	public void validateNullForm(final User user) throws Exception
	{
		if (user.getEmail().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty() || user.getUsername().isEmpty())
		{
			throw new Exception("All fields must be filled");
		}

	}

	@Override
	public void nameOnlyLetters(final User user) throws Exception
	{
		final String regex = "^[\\p{L} .'-]+$";

		if (!user.getName().matches(regex))
		{
			throw new Exception("Name must have only letters and special name characters");
		}
	}

	@Override
	public void usernameOnlyLettersNumber(final User user) throws Exception
	{
		final String regex = "^[a-z0-9]+$";

		if (!user.getUsername().matches(regex))
		{
			throw new Exception("Username must only have numbers and letters");
		}
	}

	@Override
	public void emailPatternValidation(final User user) throws Exception
	{
		final String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (!user.getEmail().matches(regex))
		{
			throw new Exception("Email has invalid pattern");
		}
	}

	@Override
	public void passwordMatch(final User user, final String password) throws Exception
	{
		if (!user.getPassword().equals(password))
		{
			throw new Exception("Passwords must match");
		}

	}

	@Override
	public void passwordPatternValidation(final User user) throws Exception
	{
		final String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$";
		// ^ # start-of-string
		// (?=.*[0-9]) # a digit must occur at least once
		// (?=.*[a-z]) # a lower case letter must occur at least once
		// (?=.*[A-Z]) # an upper case letter must occur at least once
		// (?=\S+$) # no whitespace allowed in the entire string
		// .{8,} # anything, at least eight places though
		// $ # end-of-string
		if (!user.getPassword().matches(regex))
		{
			throw new Exception(
					"Password must have at least 8 length, one number, one upper and lower case letter and no white spaces");
		}
	}

	@Override
	public void alreadyHasUsername(final User user) throws Exception
	{
		final Boolean alreadyHasUsername = userDao.alreadyHasUsername(user);

		if (alreadyHasUsername)
		{
			throw new Exception("Username already in use");
		}
	}

	@Override
	public void validateSignIn(final User user)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void validateThumbnail(final MultipartFile thumbnail) throws Exception
	{
		if (thumbnail.isEmpty())
		{
			throw new Exception("Campo obrigatório");
		}
		if (!thumbnail.getContentType().equals("image/jpeg") && !thumbnail.getContentType().equals("image/png")
				&& !thumbnail.getContentType().equals("image/bmp"))
		{
			throw new Exception("Apenas JPG, PNG e BMP são aceitos");
		}
		if (thumbnail.getSize() > 5242880)
		{
			throw new Exception("Imagem nao pode exceder 5MB");
		}

	}

	@Override
	public void validateProduct(final Product product) throws Exception
	{
		if (StringUtil.isEmpty(product.getDescription()))
		{
			throw new Exception("Descrição deve ser preenchida");
		}
		if (StringUtil.isEmpty(product.getName()))
		{
			throw new Exception("Nome deve ser preenchido");
		}
	}

	@Override
	public void validateMagicItem(final MagicItems magicItem) throws Exception
	{
		validateProduct(magicItem);
		//TODO CREATE VALIDATIONS
	}

	@Override
	public void validateMagicService(final MagicServices magicService) throws Exception
	{
		validateProduct(magicService);
		//TODO CREATE VALIDATIONS
	}

	@Override
	public void validadeCreditCard(final String creditCardNumber, final String creditCardSecurity) throws Exception
	{
		final String regexCardNumber = "[0-9]{16}";
		final String regexCardCVC = "[0-9]{4}";
		if (!creditCardNumber.matches(regexCardNumber) || !creditCardSecurity.matches(regexCardCVC))
		{
			throw new Exception("Cartão de crédito inválido!");
		}
	}
}
