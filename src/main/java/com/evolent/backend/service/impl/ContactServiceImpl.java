package com.evolent.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evolent.backend.dao.ContactRepository;
import com.evolent.backend.service.ContactService;
import com.evolent.backend.service.dto.ContactDTO;
import com.evolent.backend.service.mapper.ContactMapper;
import com.evolent.backend.service.validator.ContactValidator;

/**
 * This is Contact Service Implementation class
 * 
 * @author dharmjeet.kumar
 *
 */
@Service("contactApplicationService")
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactDao;

	//@Transactional
	public int addContact(ContactDTO contact) {
		//ContactValidator.validateContactForAdd(contact);
		return contactDao.addContact(ContactMapper.map(contact));
	}

	@Transactional
	public boolean deleteContact(int contactId) {
		return contactDao.deleteContact(contactId);
	}

	@Transactional
	public List<ContactDTO> getAllContacts() {
		return ContactMapper.map(contactDao.getAllContacts());
	}

	@Transactional
	public boolean updateContact(ContactDTO contact) {
		ContactValidator.validateContactForUpdate(contact);
		return contactDao.updateContact(ContactMapper.map(contact));
	}

	public ContactDTO getContactById(int contactId) {
		return ContactMapper.map(contactDao.getContactById(contactId));
	}
}
