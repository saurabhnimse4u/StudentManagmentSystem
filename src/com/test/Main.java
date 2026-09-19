package com.test;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		

		Player p1 = new Player("3Saurabh", 23, "s1") ;
		p1.addSponsors("Adidas");
		p1.addSponsors("Nike");
		p1.playerDetails();
		System.out.println(p1);
		
		System.out.println("");

		Player p2 = new Player("Shivani", 13, "s2") ;
		p2.addSponsors("Adidas");
		p2.addSponsors("Nike");
		p2.playerDetails();
		System.out.println(p2);
		
		
	}

}
