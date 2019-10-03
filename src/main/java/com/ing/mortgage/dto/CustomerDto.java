package com.ing.mortgage.dto;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class CustomerDto {
    @NotNull(message="First name cannot be missing or empty")
	private String firstName;
    @NotNull(message="Last name cannot be missing or empty")
	private String lastName;
    @NotNull(message="Date of birth cannot be missing or empty")
    @Past
	private Date dob;
    @NotNull(message="Gender cannot be missing or empty")
	private String geneder;
    @NotNull(message="Phone number cannot be missing or empty")
   // @Size(min=8, max=8, message="Phone number shoulbe 8 digit length")
	private Long phone;
    @NotNull(message="Email cannot be missing or empty")
    @Email
	private String email;
    @NotNull(message="Property name cannot be missing or empty")
	private String propertyName;
    @NotNull(message="Property name cannot be missing or empty")
	private String propertyType;
    @NotNull(message="Property value cannot be missing or empty")
	private String propertyValue;
    @NotNull(message="Property address cannot be missing or empty")
	private String propertyAddress;

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
    
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob)  {
		this.dob = dob;
	}
	public String getGeneder() {
		return geneder;
	}
	public void setGeneder(String geneder) {
		this.geneder = geneder;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
}
