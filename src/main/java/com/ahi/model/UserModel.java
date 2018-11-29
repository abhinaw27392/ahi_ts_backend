package com.ahi.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ahi.entity.AhiUser;

public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;
//	public UserModel(String supervisorId) {
//		this.supervisorId = supervisorId;
//	}
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String designation;
	private Date joiningDate;
	private String role;
	private Integer supervisorId;
	private String supervisorName;
	private String loginId;
	private String password;
	private String email;
	private boolean active;
	private String whoCreated;
	private Date whenCreated;
	private String whoUpdated;
	private Date whenUpdated;

	private String location;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDob() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		String strDob= formatter.format(dob);
		return strDob;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDesignation() {
		return designation;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getJoiningDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		String strJoiningDate= formatter.format(joiningDate);
		return strJoiningDate;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}
	public Integer getSupervisorId() {
		return supervisorId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginId() {
		return loginId;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhoCreated() {
		return whoCreated;
	}

	public void setWhoCreated(String whoCreated) {
		this.whoCreated = whoCreated;
	}

	public Date getWhenCreated() {
		return whenCreated;
	}

	public void setWhenCreated(Date whenCreated) {
		this.whenCreated = whenCreated;
	}

	public String getWhoUpdated() {
		return whoUpdated;
	}

	public void setWhoUpdated(String whoUpdated) {
		this.whoUpdated = whoUpdated;
	}

	public Date getWhenUpdated() {
		return whenUpdated;
	}

	public void setWhenUpdated(Date whenUpdated) {
		this.whenUpdated = whenUpdated;
	}
	
	public void setLocation(String location) {
		this.location = location; 
	}
	
	public String getLocation() {
		return location;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	
	public String getSupervisorName() {
		return supervisorName;
	}
	
}
