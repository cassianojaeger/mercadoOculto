package com.sap.imdb.validations;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.User;

@Component(value = "imdbValidate")
public class ImdbValidateHandler implements ImdbValidate {

	@Resource
	private UserDao userDao;

	@Override
	public void validateSignUp(User user) throws Exception {
		validateNullForm(user);
		nameOnlyLetters(user);
		usernameOnlyLettersNumber(user);
		emailPatternValidation(user);
		passwordPatternValidation(user);
		alreadyHasUsername(user);
	}

	@Override
	public void validateNullForm(User user) throws Exception {
		if (user.getEmail().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty()
				|| user.getUsername().isEmpty()) {
			throw new Exception("All fields must be filled");
		}

	}

	@Override
	public void nameOnlyLetters(User user) throws Exception {
		String regex = "^[\\p{L} .'-]+$";

		if (!user.getName().matches(regex)) {
			throw new Exception("Name must have only letters and special name characters");
		}
	}

	@Override
	public void usernameOnlyLettersNumber(User user) throws Exception {
		String regex = "^[a-z0-9]+$";

		if (!user.getUsername().matches(regex)) {
			throw new Exception("Username must only have numbers and letters");
		}
	}

	@Override
	public void emailPatternValidation(User user) throws Exception {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (!user.getEmail().matches(regex)) {
			throw new Exception("Email has invalid pattern");
		}
	}

	@Override
	public void passwordMatch(User user, String password) throws Exception {
		if (!user.getPassword().equals(password)) {
			throw new Exception("Passwords must match");
		}

	}

	@Override
	public void passwordPatternValidation(User user) throws Exception {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$";
		// ^ # start-of-string
		// (?=.*[0-9]) # a digit must occur at least once
		// (?=.*[a-z]) # a lower case letter must occur at least once
		// (?=.*[A-Z]) # an upper case letter must occur at least once
		// (?=\S+$) # no whitespace allowed in the entire string
		// .{8,} # anything, at least eight places though
		// $ # end-of-string
		if (!user.getPassword().matches(regex)) {
			throw new Exception(
					"Password must have at least 8 length, one number, one upper and lower case letter and no white spaces");
		}
	}

	@Override
	public void alreadyHasUsername(User user) throws Exception {
		Boolean alreadyHasUsername = userDao.alreadyHasUsername(user);

		if (alreadyHasUsername) {
			throw new Exception("Username already in use");
		}
	}

	@Override
	public void validateSignIn(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateThumbnail(MultipartFile thumbnail) throws Exception {
		if(thumbnail.isEmpty()){
			throw new Exception("Campo obrigatório");
		}
		if (!thumbnail.getContentType().equals("image/jpeg")
			&& !thumbnail.getContentType().equals("image/png")
			&& !thumbnail.getContentType().equals("image/bmp")) {
			throw new Exception("Apenas JPG, PNG e BMP são aceitos");
		}
		if(thumbnail.getSize() > 5242880){
			throw new Exception("Imagem nao pode exceder 5MB");
		}

	}

}
