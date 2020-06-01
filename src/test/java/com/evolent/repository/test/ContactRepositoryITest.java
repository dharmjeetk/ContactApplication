package com.evolent.repository.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.evolent.backend.dao.ContactRepository;
import com.evolent.backend.domain.Contact;
import com.evolent.backend.service.enums.ContactStatusEnum;
import com.evolent.itest.util.AbstractITest;

@SqlConfig(dataSource = "contactApplicationDataSource")
@Sql(scripts = { "classpath:contact.sql" })
public class ContactRepositoryITest extends AbstractITest {

	private static Logger log = Logger.getLogger(ContactRepositoryITest.class);

	@Autowired
	ContactRepository contactRepository;

	@Test
	public void testAddContact() {
		Contact contact = new Contact();
		contact.setContactId(1);
		contact.setEmailId("test@gmail.com");
		contact.setFirstName("Dharmjeet");
		contact.setLastName("Kumar");
		contact.setPhoneNumber("8978978979");
		contact.setStatus(ContactStatusEnum.ACTIVE.getValue());

		int contactId = contactRepository.addContact(contact);
		assertTrue(contactId > 0);

		Contact contactAfterAddition = contactRepository.getContactById(1);
		assertNotNull(contactAfterAddition);
		assertEquals(1, contactAfterAddition.getContactId());
		assertEquals("test@gmail.com", contactAfterAddition.getEmailId());
		assertEquals("Dharmjeet", contactAfterAddition.getFirstName());
		assertEquals("Kumar", contactAfterAddition.getLastName());
		assertEquals("8978978979", contactAfterAddition.getPhoneNumber());
		assertEquals(ContactStatusEnum.ACTIVE.getValue(), contactAfterAddition.getStatus());
	}

	@Test
	public void testDeleteContact() {
		boolean response = contactRepository.deleteContact(1);
		assertTrue(response);

		Contact contact = contactRepository.getContactById(1);
		assertNull(contact);
	}

	@Test
	public void testGetAllContacts() {
		List<Contact> contacts = contactRepository.getAllContacts();
		assertNotNull(contacts);
		assertEquals(1, contacts.size());
		assertEquals(1, contacts.get(0).getContactId());
		assertEquals("test@gmail.com", contacts.get(0).getEmailId());
		assertEquals("Dharmjeet", contacts.get(0).getFirstName());
		assertEquals("Kumar", contacts.get(0).getLastName());
		assertEquals("8978978979", contacts.get(0).getPhoneNumber());
		assertEquals(ContactStatusEnum.ACTIVE.getValue(), contacts.get(0).getStatus());
	}

	@Test
	public void testUpdateContact() {
		Contact contact = contactRepository.getContactById(1);
		assertNotNull(contact);

		contact.setFirstName("UpdateName");
		contact.setStatus(ContactStatusEnum.INACTIVE.getValue());

		boolean response = contactRepository.updateContact(contact);
		assertTrue(response);

		Contact contactAfterUpdation = contactRepository.getContactById(1);
		assertNotNull(contactAfterUpdation);
		assertEquals(1, contactAfterUpdation.getContactId());
		assertEquals("test@gmail.com", contactAfterUpdation.getEmailId());
		assertEquals("UpdateName", contactAfterUpdation.getFirstName());
		assertEquals("Kumar", contactAfterUpdation.getLastName());
		assertEquals("8978978979", contactAfterUpdation.getPhoneNumber());
		assertEquals(ContactStatusEnum.INACTIVE.getValue(), contactAfterUpdation.getStatus());
	}

}
