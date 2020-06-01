package com.evolent.backend.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.evolent.backend.domain.Contact;
import com.evolent.backend.service.dto.ContactDTO;
import com.evolent.backend.service.enums.ContactStatusEnum;

/**
 * This is Transformer class for transforming contact object from service layer
 * to domain layer and vice versa
 * 
 * @author dharmjeet.kumar
 *
 */
public class ContactMapper {

	private ContactMapper() {
		// private constructor as we don't want to make any new instance
	}

	public static Contact map(ContactDTO contact) {
		Contact domainObj = new Contact();
		if (contact.getContactId() != null) {
			domainObj.setContactId(contact.getContactId());
		}
		domainObj.setEmailId(contact.getEmailId());
		domainObj.setFirstName(contact.getFirstName());
		domainObj.setLastName(contact.getLastName());
		domainObj.setPhoneNumber(contact.getPhoneNumber());
		domainObj.setStatus(contact.getStatus().getValue());
		return domainObj;
	}

	public static List<ContactDTO> map(List<Contact> contacts) {
		return contacts.stream().map(ContactMapper::map).collect(Collectors.toList());
	}

	public static ContactDTO map(Contact contact) {
		ContactDTO serviceObj = new ContactDTO();
		serviceObj.setContactId(contact.getContactId());
		serviceObj.setEmailId(contact.getEmailId());
		serviceObj.setFirstName(contact.getFirstName());
		serviceObj.setLastName(contact.getLastName());
		serviceObj.setPhoneNumber(contact.getPhoneNumber());
		serviceObj.setStatus(ContactStatusEnum.getInstance(contact.getStatus()));
		return serviceObj;
	}
}
