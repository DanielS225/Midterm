package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double grade;
	private int credits;

	private Enrollment() {
		this.EnrollmentID = UUID.randomUUID();
	}

	public Enrollment(UUID StudentID, UUID SectionID, int credits) {
		this();
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.credits = credits;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public double getGrade(){
		return this.grade;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
}
