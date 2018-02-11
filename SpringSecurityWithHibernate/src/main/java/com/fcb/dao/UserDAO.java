package com.fcb.dao;

public interface UserDAO {
	com.fcb.entity.Users findByUserName(String username);
}
