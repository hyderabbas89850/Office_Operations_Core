package com.spring.security.mongodb.payload.response;

import java.util.List;

public class UserInfoResponse {
  private String id;
  private String username;
  private String email;
  private List<String> roles;
  private String orgId;

  public UserInfoResponse(String id, String username, String email, List<String> roles, String orgId) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.orgId=orgId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getRoles() {
    return roles;
  }

public String getOrgId() {
	return orgId;
}

public void setOrgId(String orgId) {
	this.orgId = orgId;
}
  
  
}
