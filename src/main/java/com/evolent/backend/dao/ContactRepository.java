package com.evolent.backend.dao;

import java.util.List;

import com.evolent.backend.domain.Contact;

/**
 * This is Contact DAO Manager
 * 
 * @author dharmjeet.kumar
 *
 */
/**
 * @author dharmjeet.kumar
 *
 */
public interface ContactRepository {
	/**
	 * This method adds a new contact details in system
	 * 
	 * @param contact
	 *            : Contact to be added
	 * @return contactId
	 */
	int addContact(Contact contact);

	/**
	 * This method deletes contact from the system
	 * 
	 * @param contactId
	 *            : Contact Id to be deleted
	 * @return true if successful deletion, else false
	 */
	boolean deleteContact(int contactId);

	/**
	 * This method gets all contact details from the system
	 * 
	 * @return List of Contact details
	 */
	List<Contact> getAllContacts();
	
	/**
	 * This method gets contact information by provided contact Id
	 * 
	 * @param contactId : contact id for which information is required
	 * @return Contact details for given id
	 */
	Contact getContactById(int contactId);

	/**
	 * This method updates a specified contact detail
	 * 
	 * @param contact
	 *            : updated contact details information
	 * @return true if successful updation, else false
	 */
	boolean updateContact(Contact contact);
}
