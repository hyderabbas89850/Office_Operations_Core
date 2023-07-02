package com.spring.security.mongodb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.spring.security.mongodb.models.User;
import com.spring.security.mongodb.payload.request.SignupRequest;
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<SignupRequest> getUsers() {
		List<SignupRequest> users = new ArrayList<>();
		try {
			users = (List<SignupRequest>) mongoTemplate.findAll(SignupRequest.class,"users");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findUsername(String name) {
		User user =null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("markAsDelete").is(false).and("username").is(name));
			user = mongoTemplate.findOne(query, User.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Map> getOrganizations() {
		List<Map> orgData =null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("markAsDelete").is(false));
			orgData = mongoTemplate.find(query, Map.class,"organization");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return orgData;
	}

}
