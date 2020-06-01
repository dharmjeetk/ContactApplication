package com.evolent.backend.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.backend.service.ContactService;
import com.evolent.backend.service.dto.ContactDTO;

/**
 * This is back end REST controller for maintaining Contact details
 * 
 * @author dharmjeet.kumar
 *
 */

@RestController
@RequestMapping(value = "/contact")
public class ContactRESTController {

	@Autowired
	private ContactService contactService;

	private static final Logger logger = Logger.getLogger(ContactRESTController.class);

	@PutMapping(consumes = "application/json")
	public ResponseEntity<Object> editContact(@RequestBody ContactDTO contact) {
		logger.debug("Contact With Id " + contact.getContactId() + " to be updated by application");
		boolean wasUpdated = contactService.updateContact(contact);

		String message = wasUpdated ? "successfully updated" : "not updated due to some errors";
		logger.info("Contact with id " + contact.getContactId() + " was " + message);
		HttpStatus responseStatus = wasUpdated ? HttpStatus.OK : HttpStatus.NO_CONTENT;
		return new ResponseEntity<>(responseStatus);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Object> deleteContact(@PathVariable int id) {
		logger.debug("Contact Id " + id + " to be deleted from application");
		boolean wasDeleted = contactService.deleteContact(id);

		String message = wasDeleted ? "successfully updated" : "not updated due to some errors";
		logger.info("Contact with id " + id + " was " + message);
		HttpStatus responseStatus = wasDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(responseStatus);
	}

	@GetMapping()
	public ResponseEntity<Object> getAllContacts() {
		logger.debug("Getting all Contacts in application");
		List<ContactDTO> listEmployee = null;
		try {
			listEmployee = contactService.getAllContacts();
		} catch (Exception e) {
			logger.error("Error occurred while finding all contacts from system due to " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(listEmployee);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findOrderById(@PathVariable int id) {
		logger.debug("Contact Id " + id + " to be found by application");
		ContactDTO contact = contactService.getContactById(id);
		if (contact != null) {
			logger.error("Contact found in system with id " + id);
			return new ResponseEntity<>(contact, HttpStatus.OK);
		} else {
			logger.error("No contact found in system with id " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Object> saveContact(@RequestBody ContactDTO contact) {
		logger.debug("Contact " + contact.toString() + " to be saved by application");
		int id = 0;
		try {
			id = contactService.addContact(contact);
			logger.info("Contact created in system, and being sent to external party : " + id);
		} catch (Exception e) {
			logger.error("Error occurred while saving contact to system due to " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
