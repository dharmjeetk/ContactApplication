package com.evolent.backend.service.validator;

import org.apache.commons.lang3.StringUtils;

import com.evolent.backend.service.dto.ContactDTO;
import com.evolent.backend.service.enums.ContactStatusEnum;
import com.evolent.backend.service.exceptions.ContactStatusInvalidException;
import com.evolent.backend.service.exceptions.EmailInvalidException;
import com.evolent.backend.service.exceptions.FieldLengthInvalidException;
import com.evolent.backend.service.exceptions.MandatoryFieldsMissingException;
import com.evolent.backend.service.exceptions.PhoneNumberInvalidException;

/**
 * This is Validator class for validating fields of contact object from service
 * layer before sending to domain layer to check if it has any issues
 * 
 * @author dharmjeet.kumar
 *
 */
public class ContactValidator {

	private static int nameMinLength = 0;

	private static int nameMaxLength = 140;

	private ContactValidator() {
		// private constructor as we don't want to make any new instance
	}

	public static void validateContactForAdd(ContactDTO contact) {
		validateEmailId(contact.getEmailId());
		validateFirstName(contact.getFirstName());
		validateLastName(contact.getLastName());
		validatePhoneNumer(contact.getPhoneNumber());
		validateStatus(contact.getStatus());
		validateStatusIsActive(contact.getStatus());
	}

	public static void validateContactForUpdate(ContactDTO contact) {
		validateContactId(contact.getContactId());
		validateEmailId(contact.getEmailId());
		validateFirstName(contact.getFirstName());
		validateLastName(contact.getLastName());
		validatePhoneNumer(contact.getPhoneNumber());
		validateStatus(contact.getStatus());
	}

	private static void validateContactId(Integer contactId) {
		if (contactId == null || contactId <= 0) {
			throw new MandatoryFieldsMissingException("Contact Id");
		}
	}

	private static void validateLastName(String lastName) {
		if (StringUtils.isNotBlank(lastName)
				&& !StringLengthValidator.isValid(lastName, nameMinLength, nameMaxLength)) {
			throw new FieldLengthInvalidException("Contact Last Name", nameMinLength, nameMaxLength);
		}
	}

	private static void validateStatusIsActive(ContactStatusEnum status) {
		if (!ContactStatusEnum.ACTIVE.equals(status)) {
			throw new ContactStatusInvalidException("Contact Status should be active");
		}
	}

	private static void validateStatus(ContactStatusEnum status) {
		if (status == null) {
			throw new MandatoryFieldsMissingException("Contact Status");
		}
	}

	private static void validatePhoneNumer(String phoneNumber) {
		if (!PhoneNumberValidator.isValid(phoneNumber)) {
			throw new PhoneNumberInvalidException();
		}
	}

	private static void validateFirstName(String firstName) {
		if (StringUtils.isBlank(firstName)) {
			throw new MandatoryFieldsMissingException("Contact First Name");
		}
		if (!StringLengthValidator.isValid(firstName, nameMinLength, nameMaxLength)) {
			throw new FieldLengthInvalidException("Contact First Name", nameMinLength, nameMaxLength);
		}
	}

	private static void validateEmailId(String emailId) {
		if (!EmailValidator.isValid(emailId)) {
			throw new EmailInvalidException();
		}
	}
}
