package com.userservice.user_service.dto;

public class UserDto {
	private Long id;
	private String fisrtName;
	private String lastName;
	private String emailId;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	private UserDto(Long id, String fisrtName, String lastName, String emailId) {
		super();
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
