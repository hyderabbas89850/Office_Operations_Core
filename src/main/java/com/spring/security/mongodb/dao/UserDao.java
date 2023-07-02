package com.spring.security.mongodb.dao;

import java.util.List;
import java.util.Map;

import com.spring.security.mongodb.models.User;
import com.spring.security.mongodb.payload.request.SignupRequest;

public interface UserDao {
	
	public List<SignupRequest> getUsers();

	public User findUsername(String name);

	public List<Map> getOrganizations();

}
