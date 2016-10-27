package com.sap.imdb.validations;

import com.sap.imdb.model.User;

public interface ImdbValidate {
	
//	SIGN IN VALIDATIONS
	void validateSignIn(User user);
	void alreadyHasUsername(User user);
	void passwordValidation(User user);
	//void passwordMatch(User	user);
	void nameOnlyLetters(User user);
	void usernameOnlyLettersNumber(User user);
	
//	SIGN UP VALIDATIONS
	void validateSignUp(User user);
	
}
