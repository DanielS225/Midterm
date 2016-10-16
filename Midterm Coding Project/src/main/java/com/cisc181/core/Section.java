package com.cisc181.core;

import java.util.UUID;

public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	private int GradePoints;
	
	public Section(int room, Semester semester, Course course, int GradePoints) {
		this.SectionID = UUID.randomUUID();
		this.RoomID = RoomID;
		this.SemesterID = semester.getSemesterID();
		this.CourseID  = course.getCourseID(); 
		this.GradePoints = GradePoints;
	}
	
	public UUID getSectionID() {
		return this.SectionID;
	}
	
	public int getGradePoints() {
		return this.GradePoints;
	}
}
