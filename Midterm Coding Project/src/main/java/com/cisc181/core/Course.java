package com.cisc181.core;

import java.util.UUID;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	
	public Course(String CourseName, int GradePoints) {
		this.CourseID = UUID.randomUUID();
		this.CourseName = CourseName;
		this.GradePoints = GradePoints;
	}
	
	public UUID getCourseID() {
		return this.CourseID;
	}
}
