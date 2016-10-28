package com.sap.imdb.validations;

import com.sap.imdb.model.User;

public interface ImdbValidate {
	

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
	
}
