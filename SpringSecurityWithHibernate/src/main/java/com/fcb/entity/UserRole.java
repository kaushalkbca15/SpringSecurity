package com.fcb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.User;

@Entity
@Table(name="user_role")
public class UserRole {
	
	@Id
	@Column(name="user_role_id",length=10)
	@Type(type="int")
	private Integer r_id;
	@Column(name="role",length=10)
	@Type(type="string")
	private String role;
	
	/*
	@ManyToOne(targetEntity=Users.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="username",referencedColumnName="userrole")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
