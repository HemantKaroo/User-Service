package com.userservices.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.userservices.customvalidator.InvalidEmail;
import com.userservices.customvalidator.InvalidRole;

@InvalidEmail
public class UserDTO {

	private long userId;

	@NotEmpty(message = "FirstName Can Not Be Empty.")
	@Size(min = 2, max = 25, message = "Enter Valid FirstName.")
	private String firstName;

	@NotEmpty(message = "MiddleName Can Not Be Empty.")
	@Size(min = 1, max = 25, message = "Enter Valid MiddleName.")
	private String middleName;

	@NotEmpty(message = "LastName Can Not Be Empty.")
	@Size(min = 2, max = 25, message = "Enter Valid LastName.")
	private String lastName;

	@NotEmpty(message = "Email-Id Cannot Be Empty")
	@Size(min = 10, max = 256, message = "Email-ID Should Have At Least 5 Characters")
	@Pattern(regexp = "^(.+)@(.+)$", message = "Enter A Valid Email")
	private String email;

	@Size(min = 5, max = 25)
	@NotEmpty(message = "Password Cannot Be Empty")
	private String password;

	@Size(min = 10, max = 25)
	@NotEmpty(message = "PhoneNumber Cannot Be Empty")
	private String phoneNumber;

	@Size(min = 5, max = 300)
	@NotEmpty(message = "AddressOne Cannot Be Empty")
	private String addressOne;

	@Size(min = 5, max = 300)
	@NotEmpty(message = "AddressTwo Cannot Be Empty")
	private String addressTwo;

	@Size(min = 2, max = 50)
	@NotEmpty(message = "City Cannot Be Empty")
	private String city;

	@Size(min = 2, max = 50)
	@NotEmpty(message = "State Cannot Be Empty")
	private String state;

	@Size(min = 2, max = 50)
	@NotEmpty(message = "Country Cannot Be Empty")
	private String country;

	@Size(min = 6, max = 50)
	@NotEmpty(message = "Pincode Cannot Be Empty")
	private String pincode;

	@InvalidRole
	private List<String> roles;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", addressOne=" + addressOne
				+ ", addressTwo=" + addressTwo + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", pincode=" + pincode + ", roles=" + roles + "]";
	}

}