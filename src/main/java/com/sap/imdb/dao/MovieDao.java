package com.sap.imdb.dao;

import java.util.List;

import com.sap.imdb.model.Movie;
import com.sap.imdb.model.User;

public interface MovieDao {
void save(Movie movie);
	
	void update(Movie movie);
	
	void remove(Movie movie);
	
	Movie getMovie(int id);
	
	List<Movie> getListMovie();

	List<Movie> getMoviesByTitle(String title);

	List<Movie> getListMovieByUsername(User user);
}
