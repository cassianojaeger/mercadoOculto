package com.sap.imdb.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sap.imdb.model.Movie;

@Transactional
public interface MovieService {
	
	void saveMovie(Movie movie);
	
	void updateMovie(Movie movie);
	
	void removeMovie(Movie movie);
	
	Movie getMovie(int id);
	
	List<Movie> getListMovie();
}
