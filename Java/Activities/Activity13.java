package alchemy.activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> lstnumber = new ArrayList<Integer>();
		Random nextnum = new Random();
		
		System.out.println("enter the list of integers");
		System.out.println("(EOF or non-integer to terminate):");
		
		while(scan.hasNextInt())
		{
			lstnumber.add(scan.nextInt());
		}
		
		Integer[] arr = lstnumber.toArray(new Integer[10]);
		int index = nextnum.nextInt(arr.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + arr[index]);
 
        scan.close();
	}

}
