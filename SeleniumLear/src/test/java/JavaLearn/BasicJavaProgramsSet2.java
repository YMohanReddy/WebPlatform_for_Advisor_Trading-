package JavaLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class BasicJavaProgramsSet2 {
	//Write a Java Program to generate Output "aabbbcccc" with the input "a2b3c4"
	@Test
	public void printInGivenOrder() {
		String str="a2b3c4";
		for(int i=0;i<str.length();i++) {
			if(Character.isAlphabetic(str.charAt(i))) {
				System.out.print(str.charAt(i));
			}
			else {
				int num=str.charAt(i)-'0';
				for(int j=0; j<num; j++) {
					System.out.print(str.charAt(i-1));
				}
			}
		}
	}
	
	//Write a Java Program to print the second largest number in a given array.
	@Test
	public void findSecondLargestVal() {
		int[] arr = {2,3,1,6,9,9};
		Arrays.sort(arr);
		for(int i = arr.length-1; i>0; i--) {
			if(arr[i-1]!=arr[i]) {
				System.out.println(arr[i-1]);
				break;
			}
		}
	}

	@Test
	public void outerLoop()	{
		outerloop: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i * j > 6) {
					System.out.println("Breaking");
					break outerloop;
				}
				System.out.println(i + " " + j);
			}
		}
		System.out.println("Done");
	}
	
	//replace multiple spaces with a single space
	@Test
	public void replaceMultiSpaces() {
		String input = "This   is   a   test   string    with  multiple     spaces.";
		String output = input.replaceAll("\\s+", " ");
		System.out.println("output: "+output);
	}
	
	//Write a Java Program to print the first non repeating character in a given String.
	@Test
	public void firstNonRepeatedChar() {
		String str = "mohanReddymo";
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		for (int i =0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(map.get(c).equals(1)) {
				System.out.println(c);
				return;
			}
		}
	}
	
	//Java Program to print the maximum consecutive ones in a given array.
	@Test
	public void findConsectiveOnes() {
		int[] arr = { 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 };
		int count=0,maxVal=0;
		for(int i =0; i<arr.length;i++) {
			while(i<arr.length && arr[i]==1) {  //here we have to mention length condition check first
				count++;
				i++;
			}
			maxVal=Math.max(count, maxVal);
			count=0;
		}
		System.out.println(maxVal);
	}
	
	//Java Program to print numbers 1 to 100 without using any loop(for/while/do-while).
	@Test
	public void printNums() {
		int num=1;
		printnum(num);
	}

	private void printnum(int num) {
		// TODO Auto-generated method stub
		if (num <= 100) {
			System.out.println(num);
			num++;
			printnum(num);

		}
	}
	
	//Write a Java Program to shift all zeros on the right.
	@Test
	public void shiftAllZerosRight() {
		int[] inputArray = { 1, 0, 2, 0, 3, 0, 0, 0 };
		int[] outputArray = new int[inputArray.length];
		int z=0;
		for(int i=0; i < inputArray.length; i++) {
			if(inputArray[i]!=0) {
				outputArray[z]=inputArray[i];
				z++;
			}
		}
		System.out.println(Arrays.toString(outputArray));
	}
}
