package com.evolent.frontend.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.evolent.backend.service.enums.ContactStatusEnum;
import com.evolent.backend.service.validator.PhoneNumber;

/**
 * This is UI layer DTO class for maintaining contact
 * 
 * @author dharmjeet.kumar
 *
 */
public class UIContactDTO{

	private Integer contactId;

	@Email(message = "Please enter your email addresss")
	@NotEmpty
	private String emailId;

	@NotNull(message="First Name canot be blank")
	private String firstName;

	@NotNull(message="Last Name canot be blank")
	private String lastName;

	@PhoneNumber
	private String phoneNumber;

	private ContactStatusEnum status;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ContactStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ContactStatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ContactDTO [contactId=" + contactId + ", emailId=" + emailId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", status=" + status + "]";
	}
}
