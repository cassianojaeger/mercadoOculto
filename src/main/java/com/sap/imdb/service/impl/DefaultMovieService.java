package com.sap.imdb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sap.imdb.dao.MovieDao;
import com.sap.imdb.model.Movie;
import com.sap.imdb.service.MovieService;

public class DefaultMovieService implements MovieService{

	@Resource
	private MovieDao movieDao;
	
	@Override
	public void saveMovie(Movie movie) {		
		movieDao.save(movie);
	}

	@Override
	public void updateMovie(Movie movie) {
		movieDao.update(movie);		
	}

	@Override
	public void removeMovie(Movie movie) {		
		movieDao.remove(movie);
	}

	@Override
	public Movie getMovie(int id) {
		return movieDao.getMovie(id);
	}

	@Override
	public List<Movie> getListMovie() {
		return movieDao.getListMovie();
	}

}
