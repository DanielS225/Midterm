package com.cisc181.core;

import java.util.UUID;

public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public Section(int room, Semester semester, Course course) {
		this.SectionID = UUID.randomUUID();
		this.RoomID = RoomID;
		this.SemesterID = semester.getSemesterID();
		this.CourseID  = course.getCourseID(); 
	}
}
