package com.sap.imdb.dao.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.Role;
import com.sap.imdb.model.User;

public class HibernateUserDao extends HibernateDaoSupport implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String username) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		
		return (User) getHibernateTemplate().findByCriteria(criteria).get(0);

	}
	
	@Override
	public Boolean alreadyHasUsername(User user){
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		
		return  getHibernateTemplate().findByCriteria(criteria).size()>0;
	}

	@Override
	public void save(User user) {
		Role role = new Role();
		role.setRole("ROLE_USER");
		//Admin789 senha
		role.setId(1L);
		user.setRoles(Arrays.asList(role));
		user.setLastLogin(LocalDateTime.now());
		getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		return (List<User>) getHibernateTemplate().find("from com.sap.imdb.model.User");
	}

	@Override
	public User getUser(int id) {
		return (User) getHibernateTemplate().get(User.class, id);
	}

	@Override
	public void update(User User) {
		getHibernateTemplate().update(User);
	}

	@Override
	public void remove(User User) {
		getHibernateTemplate().delete(User);
	}

}
