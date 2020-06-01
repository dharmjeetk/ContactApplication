/**
 * 
 */
package com.evolent.backend.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evolent.backend.dao.ContactRepository;
import com.evolent.backend.dao.IdGenerator;
import com.evolent.backend.domain.Contact;

/**
 * This is Contact DAO Manager Implementation
 * 
 * @author dharmjeet.kumar
 *
 */
@Repository(value = "ContactRepositoryImpl")
@Transactional(transactionManager = "contactApplicationTranscationManager")
public class ContactRepositoryImpl implements ContactRepository {

	private static final Logger logger = Logger.getLogger(ContactRepositoryImpl.class);

	@Autowired
	@Qualifier(value = "contactApplicationSessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	private IdGenerator idGenerator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evolent.repository.ContactRepository#addContact(com.evolent.domain.
	 * Contact)
	 */
	public int addContact(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		contact.setContactId(idGenerator.getNextId());
		logger.info("Contact saved successfully, Contact id =" + contact);
		return (Integer) session.save(contact);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evolent.repository.ContactRepository#deleteContact(int)
	 */
	public boolean deleteContact(int contactId) {
		Session session = sessionFactory.getCurrentSession();

		Contact contact = (Contact) session.load(Contact.class, contactId);
		if (contact != null) {
			session.delete(contact);
			logger.info("Contact deleted successfully");

			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evolent.repository.ContactRepository#getAllContacts()
	 */
	@SuppressWarnings("unchecked")
	public List<Contact> getAllContacts() {
		return sessionFactory.getCurrentSession().getNamedQuery("contact.findAll").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evolent.repository.ContactRepository#getContactById(int)
	 */
	public Contact getContactById(int contactId) {
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, contactId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evolent.repository.ContactRepository#updateContact(com.evolent.domain.
	 * Contact)
	 */
	public boolean updateContact(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.update(contact);
		logger.info("Contact updated successfully");
		return true;
	}
}
