package com.spring.security.mongodb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.security.mongodb.dao.UserDao;
import com.spring.security.mongodb.payload.request.SignupRequest;
@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Map> getUsers() {
		
		List<Map> userList = new ArrayList<>();
		try {
			
			List<Map> orgDetails = userDao.getOrganizations();
			Map<String,Object> orgMap = new HashMap<>(); 
			orgDetails.forEach(org->{
				orgMap.put(org.get("orgId")+"", org);
			});
			
			List<SignupRequest> userDetails = userDao.getUsers();
			userDetails.stream().forEach(usr->{
				Map<String,String> user = new HashMap<>();
				Map orgData = (Map) orgMap.get(usr.getOrgId());
				
				user.put("username", usr.getUsername());
				user.put("email", usr.getEmail());
				user.put("roles", usr.getRoles()+"");
				user.put("orgName", orgData.get("orgName")+"");
				user.put("logoPath", orgData.get("logoPath")+"");
				userList.add(user);
			});
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}
