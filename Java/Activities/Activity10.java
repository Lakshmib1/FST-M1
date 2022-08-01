package alchemy.activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		Set<String> lset = new HashSet<String>();
		lset.add("A");
		lset.add("B");
		lset.add("C");
		lset.add("D");
		lset.add("E");
		
		System.out.println(lset.size());
		lset.remove("C");
		if(lset.remove("Z")) {
        	System.out.println("Z removed from the Set");
        } else {
        	System.out.println("Z is not present in the Set");
        }
		boolean contains = lset.contains("B");
		System.out.println(contains);
		
		System.out.println(lset);

	}

}
