package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

	String name;
	int age;
	List<String> sponsers;
	String jNum;

	public Player(String name, int age, String jNum) {

		if (validName(name)) {
			this.name = name;
			this.age = age;
			this.jNum = jNum;
		} else {
			System.out.println("Name has issue");
		}
		sponsers = new ArrayList<String>();

	}

	public void addSponsors(String sponsor) {
		sponsers.add(sponsor);
	}

	public boolean validName(String name) {

		String nameReg = "^[a-zA-Z]+$";
		Pattern newPattern = Pattern.compile(nameReg);
		Matcher nameMatcher = newPattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name : Please enter valid name");
			return false;
		}
	}

	public void playerDetails() {
		System.out.println("==============Players Information==================");
		System.out.println(name);
		System.out.println(age);
		System.out.println(jNum);
		System.out.println(sponsers);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", sponsers=" + sponsers + ", jNum=" + jNum + "]";
	}
}
