package com.evolent.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This is Model class for maintaining contact
 * 
 * @author dharmjeet.kumar
 *
 */
@Entity
@Table(name = "CONTACT")
@NamedQuery(name = "contact.findAll", query = "from Contact c")
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4811474799266486075L;

	@Id
	@Column(name = "CONTACT_ID")
	private int contactId;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "STATUS")
	private String status;

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", emailId=" + emailId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNumber=" + phoneNumber + ", status=" + status + "]";
	}

}
