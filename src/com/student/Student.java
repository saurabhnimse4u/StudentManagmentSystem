package com.student;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studId;
	private List<String> courses;

	public Student(String name, int age, String studId) {
		super();
		if (validAge(age) && validName(name) && validID(studId)) 
		this.name = name;
		this.age = age;
		this.studId = studId;
		courses = new ArrayList<String>();
	  }

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}



	public List<String> getCourses() {
		return courses;
	}

	public void enrollACourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student enroll to: " + course + " course successfully");
			} else {
				System.err.println("Alreay enrolled: " +course);
			}
		}
	}
	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("Selenium") || course.equalsIgnoreCase("RestAssured")) {
			return true;
		} else {
			System.err.println("Invalid course selected please select valid course from the list: " + courses);
			return false;
		}
	}

	public boolean validAge(int age) {
		if (age >= 18 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age: age should be between 18 to 35");
			return false;
		}
	}

	public boolean validName(String name) {
		String nameRegex = "^[a-zA-Z]+$";
		Pattern newPattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = newPattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name : Please enter alphabates only");
			return false;
		}
	}

	public boolean validID(String studId) {
		String studIDRegex = "S-\\d+$";
		Pattern newPattern = Pattern.compile(studIDRegex);
		Matcher nameMatcher = newPattern.matcher(studId);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name : Please enter valid student id e.g S-11");
			return false;
		}
	}

	public void printStudentInformation() {
		System.out.println("===========Student Information=============");
		System.out.println("Student Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Student ID: " + studId);
		System.out.println("Enrolled for: " + courses);
	}

	@Override
	public String toString() {
		return "Student [name = " + name + ", age = " + age + ", studId = " + studId + ", courses = " + courses + "]";
	}



	public String getStudId() {
		// TODO Auto-generated method stub
		return studId;
	}




}
