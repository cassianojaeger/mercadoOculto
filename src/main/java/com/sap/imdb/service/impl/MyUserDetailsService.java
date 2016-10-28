package com.sap.imdb.service.impl;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.Role;
import com.sap.imdb.model.User;
import com.sap.imdb.service.UserService;

@Transactional
public class MyUserDetailsService implements UserDetailsService {

	// get user from the database, via Hibernate
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		User user = userDao.findByUserName(username);
		userDao.update(user);
		
		
		try {
			user.setLastLogin(LocalDateTime.now());
			userService.updateUserLoginDate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}
}