package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double grade;

	private Enrollment() {
		this.EnrollmentID = UUID.randomUUID();
	}

	public Enrollment(UUID StudentID, UUID SectionID) {
		this();
		this.StudentID = StudentID;
		this.SectionID = SectionID;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
}
