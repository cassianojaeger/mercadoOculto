package com.sap.imdb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sap.imdb.dao.MovieDao;
import com.sap.imdb.model.Movie;

public class HibernateMovieDao extends HibernateDaoSupport implements MovieDao {
	
	@Override
	public void save(Movie movie){
		getHibernateTemplate().save(movie);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getListMovie() {
		return (List<Movie>) getHibernateTemplate()
				.find("from com.sap.imdb.model.Movie");
	}

	@Override
	public Movie getMovie(int id) {
		return (Movie) getHibernateTemplate()
				.get(Movie.class, id);
	}
	
	@Override
	public void update(Movie Movie){
		getHibernateTemplate().update(Movie);
	}
	
	@Override
	public void remove(Movie Movie){
		getHibernateTemplate().delete(Movie);
	}

}
