/**
 * 
 */
package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.Exceptions.PersonException;

import com.cisc181.eNums.eTitle;

/**
 * @author Dad
 *
 */
public class Employee_Test {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Tests staff constructor and salary getter
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testArrayOfEmployees() {
		ArrayList<Staff> employees = new ArrayList<Staff>();
		double total = 0;
		for (double salary = 25000; salary < 150000; salary += 25000) {
			total += salary;
			try {
				Date DOB = Date.valueOf("1958-12-12");
				Date hire = Date.valueOf("2015-8-5");
				Staff newStaff = new Staff("John","M","Doe",DOB,"123 Way Rd.","(302) 123-4567","John@123.org","9-5",1,salary,hire,eTitle.MR);
				employees.add(newStaff);
			} catch (PersonException e) {
				
			}
		}
		double money = 0;
		for (Staff employee : employees) {
			money += employee.getSalary();
		}
		assertEquals(total/5,money/5,0);// two values are equals to within a range of 0 (are exactly equal)
	}
	
	/**
	 * Tests PersonException throwing by Staff constructor with age > 100
	 */
	@Test
	public void testBadDOB() {
		try {
			Staff old = new Staff("John","M","Doe",Date.valueOf("1908-12-12"),"123 Way Rd.","(302) 123-4567","John@123.org","9-5",1,50000.0,Date.valueOf("2015-8-5"),eTitle.MR);
			fail("Expect a PersonException to be thrown");
		} catch (PersonException e) {// TODO - confirm that exception is caught
			assertEquals(e.getMessage(),"Age is invalid");
		}
	}
	
	/**
	 * Tests PersonException throwing by Staff constructor with invalid phone number
	 */
	@Test
	public void testBadPhone() {
		try {
			Staff newStaff = new Staff("John","M","Doe",Date.valueOf("1958-12-12"),"123 Way Rd.","Phone number","John@123.org","9-5",1,50000,Date.valueOf("2015-8-5"),eTitle.MR);
			fail("Expect a PersonException to be thrown");
		} catch (PersonException e) {// TODO - confirm that exception is caught
			assertEquals(e.getMessage(),"Phone number is not valid American number");
		}
	}

}
 