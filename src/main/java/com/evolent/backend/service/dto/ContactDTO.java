package com.evolent.backend.service.dto;

import com.evolent.backend.service.enums.ContactStatusEnum;

/**
 * This is Service layer DTO class for maintaining contact
 * 
 * @author dharmjeet.kumar
 *
 */
public class ContactDTO {

	private Integer contactId;

	private String emailId;

	private String firstName;

	private String lastName;

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
