package alchemy.activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(1, "A");
		hmap.put(2, "B");
		hmap.put(3, "C");
		hmap.put(4, "D");
		hmap.put(5, "E");
		
		System.out.println(hmap);
		System.out.println(hmap.size());
		
		hmap.remove(2);
		System.out.println("updated map "+ hmap);
		
		if(hmap.containsValue("E"))
			System.out.println("E is in the list");
		else
			System.out.println("E is not in the list");
		
	}

}
