package com.cisc181.Exceptions;

import com.cisc181.core.Person;

public class PersonException extends Exception {
	private Person person;
	
	public PersonException(Person person) {
		this.person = person;
	}
	
	public PersonException(Person person, String message) {
		super(message);
		this.person = person;
	}
}
