package com.fcb.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class Users {

	private String username;
	private String password;
	private Integer status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "username",referencedColumnName="username")
	private Set<UserRole> userrole;

	
	@Id
	@Type(type = "string")
	@Column(name = "username", length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 20)
	@Type(type = "string")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "status", length = 1)
	@Type(type = "int")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<UserRole> getUserrole() {
		return userrole;
	}

	public void setUserrole(Set<UserRole> userrole) {
		this.userrole = userrole;
	}

}
