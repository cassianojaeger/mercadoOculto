package com.sap.imdb.validations;

import org.springframework.web.multipart.MultipartFile;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Product;
import com.sap.imdb.model.User;


public interface ImdbValidate
{


	//	SIGN UP VALIDATIONS
	void validateSignUp(User user) throws Exception;

	void validateNullForm(User user) throws Exception;

	void alreadyHasUsername(User user) throws Exception;

	void passwordMatch(User user, String password) throws Exception;

	void passwordPatternValidation(User user) throws Exception;

	void nameOnlyLetters(User user) throws Exception;

	void usernameOnlyLettersNumber(User user) throws Exception;

	void emailPatternValidation(User user) throws Exception;

	//	SIGN IN VALIDATIONS
	void validateSignIn(User user) throws Exception;

	// THUMNAIL VALIDATOINS
	void validateThumbnail(MultipartFile thumbnail) throws Exception;

	//CREATE PRODUCTS VALIDATIONS
	void validateProduct(Product product) throws Exception;

	void validateMagicItem(MagicItems magicItem) throws Exception;

	void validateMagicService(MagicServices magicService) throws Exception;

	void validadeCreditCard(String creditCardNumber, String creditCardSecurity) throws Exception;

}
