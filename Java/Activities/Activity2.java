package alchemy.activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		int[] arr = {10, 77, 10, 54, -11, 10,10};
		int searchnum = 10;
		int fixednum = 30;
		
		System.out.println("original array "+Arrays.toString(arr));
		
		System.out.println(result(arr,searchnum,fixednum));
	}
	
		public static boolean result(int[] numbers, int searchnum, int fixednum)
		{
			int tempsum=0;
			for (int i : numbers) {
				if(i == searchnum)
				{
					tempsum+=searchnum;
				}
				
				if(tempsum>fixednum)
				{
					break;
				}
			}
			
			return tempsum == fixednum;
			
		}
	
	}


