package com.sap.imdb.dao.impl;

import java.io.File;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sap.imdb.dao.MovieDao;
import com.sap.imdb.model.Movie;
import com.sap.imdb.model.User;

public class HibernateMovieDao extends HibernateDaoSupport implements MovieDao {

	@Override
	public void save(Movie movie) {
		getHibernateTemplate().save(movie);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getListMovie() {
		return (List<Movie>) getHibernateTemplate().find("from com.sap.imdb.model.Movie");
	}

	@Override
	public Movie getMovie(int id) {
		return (Movie) getHibernateTemplate().get(Movie.class, id);
	}

	@Override
	public void update(Movie movie) {
		getHibernateTemplate().update(movie);
	}

	@Override
	public void remove(Movie movie) {
		try {

			File file = new File(
					"C:/Users/i857753/Documents/WorkspaceIMDB/MFIMDB/src/main/webapp" + movie.getThumbnail());
			getHibernateTemplate().delete(movie);
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Filme nao possui thumbnail");
			}						
		} catch (ConstraintViolationException e) {			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMoviesByTitle(String title) {
		String query = "from com.sap.imdb.model.Movie where title like :title";
		return (List<Movie>) getHibernateTemplate().findByNamedParam(query, "title", '%' + title + '%');
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getListMovieByUsername(User user){
		String query = "select wishlist from com.sap.imdb.model.User where username like :username";
		return (List<Movie>) getHibernateTemplate().findByNamedParam(query, "username", user.getUsername());
	}
}
