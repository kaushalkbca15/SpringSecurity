package com.fcb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fcb.entity.Users;

@Repository
public class UserDAOImpl implements UserDAO{

	static{
		System.out.println(UserDAOImpl.class.getName());
	}
	
	@Autowired//(required=true)
	private SessionFactory sessionFactory;
	
	//@Autowired
	private DataSource  dataSource;
	

	@SuppressWarnings("unchecked")
	public Users findByUserName(String username) {
		Session session=sessionFactory.openSession();
		
		System.out.println("dao class  "+sessionFactory+"username::::>"+username);
		
		List<Users> users = new ArrayList<Users>();
		users = session.createQuery("from Users")
				.list();
	
		for (Users users2 : users) {
			System.out.println(users2);
		}
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
	
}
