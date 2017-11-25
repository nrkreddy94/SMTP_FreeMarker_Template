package com.acc.smtp.models;

public class UserAccount {

	private String email;
	private String lastName;
	private String firstName;
	private String username;
	private String company;
	private String fromAddress;
	private String subject;

	public UserAccount() {
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public UserAccount(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "UserAccount [email=" + email + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", username=" + username
				+ ", company=" + company + ", fromAddress=" + fromAddress
				+ ", subject=" + subject + "]";
	}

}