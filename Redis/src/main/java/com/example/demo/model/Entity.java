package com.example.demo.model;

import java.io.Serializable;

public class Entity  implements Serializable{
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String status;
	
	public Entity(String firstName, String lastName, String emailAddress, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Entity [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", status=" + status + "]";
	}
	
	

}
