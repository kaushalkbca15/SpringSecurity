package com.fcb.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fcb.dao.UserDAO;
import com.fcb.entity.UserRole;
import com.fcb.entity.Users;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	static{
		System.out.println(MyUserDetailsService.class.getName());
	}
	
	@Autowired
	private UserDAO userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		System.out.println(userDao+"::userDao");
		System.out.println(username+"=======================");
		Users user= userDao.findByUserName(username);
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserrole());
		return buildUserForAuthentication(user, authorities);
		
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(Users user, List<GrantedAuthority> authorities) {
		//return new User(user.getUsername(), user.getPassword(), user.getStatus(), true, true, true, authorities);
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}
}
