package com.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studList;
	private static Scanner scanner;

	public static void main(String[] args) {

		System.out.println("=============Student Management System===========");
		
		scanner = new Scanner(System.in);
		studList = new ArrayList<Student>();
		
		while (true) {
			System.out.println("==========Welcome===================");
			System.out.println("Select an option");
			System.out.println("1 Register a student");
			System.out.println("2 Find student with StudentID");
			System.out.println("3 List all Student Information");
			System.out.println("4 List student information in sorted order");
			System.out.println("5 Exit");

			int option = scanner.nextInt();
			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentByID(scanner);
				break;
			case 3:
				printAllStudentInformation();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
			default:
				System.out.println("Invalid option is selected");
			}
		}
	}

	private static void enrollStudent(Scanner scanner) {
		System.out.println("Enter student name: ");
		String name = scanner.next();
		System.out.println("Enter student age: ");
		int age = scanner.nextInt();
		System.out.println("Enter student ID");
		String studId = scanner.next();
		
		Student stud = new Student(name, age, studId);
		studList.add(stud);
		while (true) {
			System.out.println("Enter course :");
			String course = scanner.next();
			if (course.equals("done")) {
				break;
			}
			stud.enrollACourse(course);
		}
		stud.printStudentInformation();
	}
	
	private static void findStudentByID(Scanner scanner) {
		Student studentFound = null;
		System.out.println("Enter the Student ID and search: ");
		String studID=scanner.next();
		try {
			studentFound = studList.stream().filter(student -> student.getStudId().equalsIgnoreCase(studID)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data found"));
		} catch (RuntimeException e) {
			System.out.println("Record not found: 2" + studID + " ");
		}
		studentFound.printStudentInformation();
	}

	private static void printAllStudentInformation() {	
		if(studList.size()>0) {
		System.out.println("=====Print all student information====");
		for (Student s : studList) {
			s.printStudentInformation();
		}
        System.out.println("====Printed=======");
		}
		else {
			System.err.println("Student List is empty");
		}
	}

	private static void exit() {
		System.exit(0);
	}

//	// Comparator
	private static void sortByName() {
		Comparator<Student> studentNameCompare = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studList, studentNameCompare);
		//System.out.println(studList);
		printAllStudentInformation();
		
	}
//
//    // Stream and Exception handling
//	public static Student findSearchStudentID(String studId) {
//		Student result = null;
//		try {
//			result = studList.stream().filter(x -> x.getStudId().equalsIgnoreCase(studId)).findFirst()
//					.orElseThrow(() -> new RuntimeException("No Data found"));
//		} catch (RuntimeException e) {
//			System.out.println("Record not found" + studId + " ");
//		}
//		return result;
//    }

}
