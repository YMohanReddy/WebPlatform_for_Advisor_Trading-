package JavaLearn;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class BasicJavaPrograms {
	@Test
	public void findPrime() {
		System.out.println("Enter a num: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		for(int i =1; i<num/2; i++) {
			if(num%i == 0) {
				count++;
			}
		}
		if(count>2) {
			System.out.println("Non Prime");
		}
		else {
			System.out.println("prime");
		}
	}
	
	@Test
	public void reverseNum() {
		int num=12345;
		while(num>0) {
			System.out.print(num%10);
			num = num/10;
		}
	}
	
	@Test
	public void reverseNum1() {
		int n=12345;
//		String num = String.valueOf(n);
		StringBuffer sb = new StringBuffer(String.valueOf(n));
		System.out.println("Output is: "+sb.reverse());
	}
	
	@Test
	public void fibonacciSeries() {
		int n=13;
		int first=0,second=1,result;
		for (int i=1;i<n;i++) {
			System.out.println(first);
			int next=first+second;
			first=second;
			second=next;
		}
	}
	
	@Test
	public void armstrongNumber() {
		int n = 153;
		int res=0;
		int len = String.valueOf(n).length();
		
		while(n>0) {
			res += Math.pow(n%10, len);
			n=n/10;
		}
		System.out.println(res);
	}
	
	@Test
	public void palindromeNum() {
		int n=1234321;
		String str = String.valueOf(n);
		String sb = new StringBuffer(str).reverse().toString();
		System.out.println(sb.toString());
		String isPalin= (str.equals(sb))? "Palindrome" : "Not Palindrome";
		
		System.out.println("Given num is "+isPalin);
	}
	
	@Test
	public void findNumOfWords() {
		String n="I'm Mohan Reddy";
		String[] list = n.split(" ");
		System.out.println(list.length);
	}
	
	@Test
	public void occuranceOfChar() {
		String n="I'm Mohan Reddy";
		int len = n.length() - n.replace("d", "").length();
		System.out.println(len);
	}
	
	@Test
	public void replaceAllLearning() {
		//use replaceAll while dealing with regular expressions
		String myString = "__1_6____3__6_345____0";

		String regex = "\\d";
		String replacement = "x";

		String newString = myString.replaceAll(regex, replacement); 
		System.out.println(newString);
		// __x_x____x__x_xxx____x
	}
	
	@Test
	public void replaceAllLearning2() {
		//use replaceAll while dealing with regular expressions
		String myString = "   Horse         Cow\n\n   \r Camel \t\t Sheep \n Goat        ";

		String regex = "\\s";
		String replacement = "";

		String newString = myString.replaceAll(regex, replacement); 
		// HorseCowCamelSheepGoat
		System.out.println(newString);
	}
	
	@Test
	public void reverseWordInString() {
		String str = "Write a java program to reverse each word of a given string";
		String[] arrOfStr = str.split(" ");
		for(String word: arrOfStr) {
			String res = new StringBuffer(word).reverse().toString();
			System.out.print(res+" ");
		}
	}
	
//	Write a java program to reverse a given string with preserving the position of spaces
	@Test
	public void reverseStringWithPreservingPositions() {
		String str = "Reverse a string preserving space positions";
		char [] charArr = str.toCharArray();
		String reversedStr = new StringBuffer(str).reverse().toString().replace(" ", "");
		System.out.println(reversedStr);
		int[] arr = new int[str.length()];
		for (int i=0; i<str.length(); i++) {
			if(charArr[i] == ' ') {
				arr[i]=' ';
			}
		}
		StringBuffer sb = new StringBuffer(reversedStr);
		for(int i=0; i<str.length(); i++) {
			if (arr[i]==' ') {
				sb.insert(i, " ");
			}
		}
		System.out.println(str);
		System.out.println(sb);
	}
	
	//Write a Java Program to print the sum of digits of a given integer.
	@Test
	public void sumOfDigits() {
		int num=123, res=0;
		String str = String.valueOf(num);
		for(int i=0; i<str.length(); i++) {
//			res+= Integer.parseInt(String.valueOf(str.charAt(i)));
			res+= str.charAt(i)-'0';
//			System.out.println(str.charAt(i)-'0');
		}
		System.out.println(res);
	}
//	use int i = '1' - 0; // this will convert char to int
	 // Converting the Character to it's int value
    // using getNumericValue() method of Character Class
//    int a = Character.getNumericValue(ch);
	
	//---------------------------------------------
	
	//Write a Java Program to get the count of Capitalized words in a String.
	@Test
	public void countOfCapitalLetters() {
		String str = "Yarraguravagari Mohan RedDY";
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
				count++;
			}
		}
		System.out.println("Count of capital letters: "+count);
	}
	
	//Write a Java Program to find the longest consecutive occurrence of integers in a given array.
	@Test
	public void findLonestConsecutiveOccurance() {
		int[] arr = { 4, 3, 25, 6, 7, 8, 9, 2, 3, 10 };
		int count=1,maxVal=0;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i]+1==arr[i+1]) {
				count=count+1;
				System.out.println(arr[i] +" < "+arr[i+1]);
				System.out.println("i val: "+i +" count: "+count);
			}
			else {
				count=1;
			}
			maxVal = Math.max(maxVal, count);
//			if(count>maxVal) {
//				maxVal=count;
//			}
		}
		System.out.println(maxVal);
	}
}
