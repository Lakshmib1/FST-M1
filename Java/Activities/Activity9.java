package alchemy.activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
		List<String> mylist = new ArrayList<String>();
		mylist.add("Lakshmi");
		mylist.add("Reya");
		mylist.add("Kamesh");
		mylist.add("Raju");
		mylist.add("Jeeva");
		
		System.out.println(mylist.get(2));
		
		mylist.contains("Lakshmi");
		
		Iterator<String> it = mylist.iterator();
		
		while(it.hasNext()) {
			String next = it.next();
			System.out.println(next);
		}
		System.out.println(mylist.size());
		
	}

}
