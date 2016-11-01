package com.sap.imdb.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sap.imdb.model.Movie;

@Transactional
public interface MovieService {
	
	void saveMovie(Movie movie);
	
	void updateMovie(Movie movie);
	
	void removeMovie(Movie movie);
	
	Movie getMovie(int id);
	
	List<Movie> getListMovie();

	void uploadThumbnail(MultipartFile file, Movie movie) throws Exception;

	List<Movie> getMoviesByTitle(String title);

}
