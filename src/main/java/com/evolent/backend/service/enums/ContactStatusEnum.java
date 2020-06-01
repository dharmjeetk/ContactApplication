package com.evolent.backend.service.enums;

/**
 * Valid values for Contact status
 * 
 * @author dharmjeet.kumar
 *
 */
public enum ContactStatusEnum {
	ACTIVE("A"), INACTIVE("I");

	private String value;

	ContactStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ContactStatusEnum getInstance(String value) {

		for (ContactStatusEnum e : ContactStatusEnum.values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Cannot parse value into ContactStatusEnum " + value);
	}
}
