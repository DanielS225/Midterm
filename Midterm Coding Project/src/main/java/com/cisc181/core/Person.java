package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cisc181.Exceptions.PersonException;

/*
 * comment
 */
public abstract class Person implements java.io.Serializable {

	private Date DOB;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String address;
	private String phone_number;
	private String email_address;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB) throws PersonException {
		if (this.bValidAge(DOB) == true) {
			this.DOB = DOB;
		} else
			throw new PersonException(this,"Age is invalid");

	}

	public void setAddress(String newAddress) {
		address = newAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setPhone(String newPhone_number) throws PersonException {
		if (bNumberValid(newPhone_number) == true) {
			phone_number = formatNumber(newPhone_number);
		} else
			throw new PersonException(this,"Phone number is not valid American number");

	}

	public String getPhone() {
		return phone_number;
	}

	public void setEmail(String newEmail) {
		email_address = newEmail;
	}

	public String getEmail() {
		return email_address;
	}

	/*
	 * Constructors No Arg Constructor
	 */
	public Person() {

	}

	/*
	 * Constructors Constructor with arguments
	 */

	public Person(String FirstName, String MiddleName, String LastName, Date DOB, String Address, String Phone_number,
			String Email) throws PersonException {
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.setDOB(DOB);
		this.address = Address;
		this.setPhone(Phone_number);
		this.email_address = Email;

	}

	public void PrintName() {
		System.out.println(this.FirstName + ' ' + this.MiddleName + ' ' + this.LastName);
	}

	public void PrintDOB() {
		System.out.println(this.DOB);
	}

	public int PrintAge() {
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;
		birthDate.setTime(this.DOB);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		} else {
			age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

			// If birth date is greater than todays date (after 2 days
			// adjustment of
			// leap year) then decrement age one year
			if ((birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3)
					|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
				age--;

				// If birth date and todays date are of same month and birth day
				// of
				// month is greater than todays day of month then decrement age
			} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}

			System.out.println("age is " + age);
		}
		return age;

	}

	public boolean bValidAge(Date DOB) {
		boolean valid = false;
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;
		birthDate.setTime(DOB);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		} else {
			age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

			// If birth date is greater than todays date (after 2 days
			// adjustment of
			// leap year) then decrement age one year
			if ((birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3)
					|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
				age--;

				// If birth date and todays date are of same month and birth day
				// of
				// month is greater than todays day of month then decrement age
			} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		}
		if (age <= 100)
			valid = true;
		return valid;

	}

	/**
	 * Tests that the phone number passed to it is a valid American phone number
	 * (by format)
	 * 
	 * @param newPhone_number
	 * @return
	 */
	public boolean bNumberValid(String newPhone_number) {
		String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(newPhone_number).matches();
	}

	/**
	 * Formats (valid) American phone numbers to a consistent format (AAA)
	 * NNN-NNNN
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public String formatNumber(String phoneNumber) {
		String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.replaceFirst("($1) $2-$3");
	}
}