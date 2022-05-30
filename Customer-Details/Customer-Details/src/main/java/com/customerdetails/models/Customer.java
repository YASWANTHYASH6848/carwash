package com.customerdetails.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document(collection = "customerservice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private int id;

	@NotEmpty(message = "Name cannot be null, please enter your name")
	private String name;

	@Length(min = 4, message = "Please enter a password with length of 4 or more")
	private String password;

	@NotEmpty(message = "please provide your address!")
	private String address;

	@Email(message = "Provide a valid email address! ")
	private String emailAddress;

	private String carModel;

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Customer(int id, String name, String password, String address, String emailAddress, String carModel,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.emailAddress = emailAddress;
		this.carModel = carModel;
		this.role = role;
	}

}