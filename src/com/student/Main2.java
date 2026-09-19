package com.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	private static List<Student> studList;

	public static void main(String[] args) {

		System.out.println("=============Student Management System===========");
		
		 Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println("Entered name is "+name);
        
        System.out.println("Enter your age");
        int age = scanner.nextInt();
        System.out.println("Entered age is "+age);
        
		
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
