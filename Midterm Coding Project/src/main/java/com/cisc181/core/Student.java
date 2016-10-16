package com.cisc181.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;
import com.cisc181.Exceptions.PersonException;

public class Student extends Person {

	private eMajor Major;
	private UUID StudentID;
	private double GPA;
	private double credits;
	private ArrayList<Enrollment> enrollment;

	public eMajor getMajor() {
		return this.Major;
	}

	public void setMajor(eMajor Major) {
		this.Major = Major;
	}

	public UUID getStudentID() {
		return this.StudentID;
	}

	public Student(String FirstName, String MiddleName, String LastName, Date DOB, eMajor Major, String Address,
			String Phone_number, String Email) throws PersonException {
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email);
		this.StudentID = UUID.randomUUID();
		this.Major = Major;

	}

	@Override
	public void PrintName() {
		System.out.println(getLastName() + "," + getFirstName() + ' ' + getMiddleName());
	}

	public void PrintName(boolean bnormal) {
		super.PrintName();
	}

	public ArrayList<Enrollment> getEnrollment() {
		return this.enrollment;
	}

	public void setEnrollment(ArrayList<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}

	public void addEnrollment(UUID StudentID, UUID SectionID, int GradePoints) {
		Enrollment newEnrollment = new Enrollment(StudentID, SectionID, GradePoints);
		ArrayList<Enrollment> e = new ArrayList<Enrollment>();
		if (this.enrollment != null) {
			for (Enrollment enrollment : this.getEnrollment()) {
				e.add(enrollment);
			}
		} else {
			this.enrollment = new ArrayList<Enrollment>();
		}
		e.add(newEnrollment);
		this.setEnrollment(e);
	}

	public void removeEnrollment(Enrollment dropped) {
		this.enrollment.remove(dropped);
	}

	public double getGPA() {
		return this.GPA;
	}

	public void setGPA(double gPA) {
		this.GPA = gPA;
	}

	public double getCredits() {
		return this.credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

}