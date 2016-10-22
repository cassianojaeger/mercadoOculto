package com.sap.imdb.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.User;

public class HibernateUserDao extends HibernateDaoSupport implements UserDao{
	
	@Override
	public void save(User user){
		getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		return (List<User>) getHibernateTemplate()
				.find("from com.sap.imdbr.model.User");
	}

	@Override
	public User getUser(int id) {
		return (User) getHibernateTemplate()
				.get(User.class, id);
	}
	
	@Override
	public void update(User User){
		getHibernateTemplate().update(User);
	}
	
	@Override
	public void remove(User User){
		getHibernateTemplate().delete(User);
	}
}
