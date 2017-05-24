package com.sap.imdb.dao.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.Role;
import com.sap.imdb.model.User;
import com.sap.imdb.model.UserTypes;


public class HibernateUserDao extends HibernateDaoSupport implements UserDao
{

	@Override
	public User findByUserName(final String username)
	{
		final DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	public Boolean alreadyHasUsername(final User user)
	{
		final DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));

		return getHibernateTemplate().findByCriteria(criteria).size() > 0;
	}

	@Override
	public void save(final User user)
	{
		final Role role;
		role = getRoleByUserType(user.getUserTypes());
		user.setRoles(Arrays.asList(role));
		user.setLastLogin(LocalDateTime.now());
		getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser()
	{
		return (List<User>) getHibernateTemplate().find("from com.sap.imdb.model.User");
	}

	@Override
	public User getUser(final int id)
	{
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public void update(final User User)
	{
		getHibernateTemplate().update(User);
	}

	@Override
	public void remove(final User User)
	{
		getHibernateTemplate().delete(User);
	}

	private Role getRoleByUserType(final UserTypes userType)
	{
		final DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
		criteria.add(Restrictions.eq("role", "ROLE_" + userType));

		return (Role) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
}

