package com.sap.imdb.service.impl;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import com.sap.imdb.dao.MovieDao;
import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.Movie;
import com.sap.imdb.model.User;
import com.sap.imdb.service.UserService;
import com.sap.imdb.validations.ImdbValidate;

public class DefaultUserService implements UserService{

	@Resource
	private UserDao userDao;
	@Resource
	private ImdbValidate ImdbValidate;
	@Resource
	private MovieDao movieDao;
	
	@Override
    public User findByUsername(String username) {
        return userDao.findByUserName(username);
    }
	
	@Override
	public void saveUser(User user) throws Exception {		
		ImdbValidate.validateSignUp(user);
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		ImdbValidate.validateSignUp(user);
		userDao.update(user);		
	}
	
	@Override
	public void updateUserLoginDate(User user) throws Exception {
		userDao.update(user);
	}

	@Override
	public void removeUser(User user) {	
		userDao.remove(user);
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getListUser() {
		return userDao.getListUser();
	}
	
	@Override
	public String saveRemoveWishlist(int movieId, Principal principal){
		String username = principal.getName();
		Movie movie = movieDao.getMovie(movieId);
		for(Movie userMovie: userDao.findByUserName(username).getWishlist()){
			if(userMovie.getId() == movie.getId()){
				User user = userDao.findByUserName(username);
				user.getWishlist().remove(movie);
				userDao.update(user);
				return "Filme removido da wishlist";
			}
		}
		User user = userDao.findByUserName(username);
		user.getWishlist().add(movie);
		userDao.update(user);
		return "Filme adicionado no wishlist";
	}
	
	@Override		
	public List<Movie> showWishlist(Principal principal){
		String username = principal.getName();
		User user = userDao.findByUserName(username);
		return movieDao.getListMovieByUsername(user);
	}
	
}
