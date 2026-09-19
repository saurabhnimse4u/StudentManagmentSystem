package com.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	private static List<Student> studList;

	public static void main(String[] args) {

		System.out.println("=============Student Management System===========");

		Student s1 = new Student("Salman", 19, "S-1");
		s1.enrollACourse("Java");
		s1.enrollACourse("Selenium");
		// s1.enrollACourse("PHP");
//		s1.enrollACourse("Java");
		 s1.printStudentInformation();

		System.out.println(" ");

		Student s2 = new Student("Arnav", 32, "S-2");
		s2.enrollACourse("Java");
		 s2.printStudentInformation();

		Student s3 = new Student("Brinda", 25, "S-2");
		s3.enrollACourse("Java");
		 s3.printStudentInformation();

		System.out.println();

		studList = new ArrayList<>();
		studList.add(s1);
		studList.add(s2);
		studList.add(s3);

		// System.out.println(studList);
		Student result = findSearchStudentID("S-2");
		System.out.println("Result: " + result);

		sortByName();

	}
// Comparator
	private static void sortByName() {
		Comparator<Student> studentNameCompare =(o1,o2)->o1.getName().compareTo(o2.getName()); 
		Collections.sort(studList, studentNameCompare);
		System.out.println(studList);
	}
// Stream and Exception handling
	public static Student findSearchStudentID(String studId) {
		Student result = null;
		try {
			result = studList.stream().filter(x -> x.getStudId().equalsIgnoreCase(studId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data found"));
		} catch (RuntimeException e) {
			System.out.println("Record not found" + studId + " ");
		}
		return result;
	}

}
