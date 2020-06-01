package com.evolent.backend.service;

import java.util.List;

import com.evolent.backend.service.dto.ContactDTO;

/**
 * This is Contact Service Layer
 * 
 * @author dharmjeet.kumar
 *
 */
public interface ContactService {

	/**
	 * This method adds a new contact details in system
	 * 
	 * @param contact : Contact to be added
	 * @return contactId
	 */
	int addContact(ContactDTO contact);

	/**
	 * This method deletes contact from the system
	 * 
	 * @param contactId : Contact Id to be deleted
	 * @return true if successful deletion, else false
	 */
	boolean deleteContact(int contactId);

	/**
	 * This method gets all contact details from the system
	 * 
	 * @return List of Contact details
	 */
	List<ContactDTO> getAllContacts();

	/**
	 * This method updates a specified contact detail
	 * 
	 * @param contact : updated contact details information
	 * @return true if successful updation, else false
	 */
	boolean updateContact(ContactDTO contact);

	/**
	 * This method get particular contact details
	 * 
	 * @param contactId :Contact Id to be search all Information
	 * @return Contact information for particular User
	 */
	public ContactDTO getContactById(int contactId);

}
