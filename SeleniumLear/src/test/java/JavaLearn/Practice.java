package JavaLearn;

import java.util.HashMap;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Practice {

	@Test
	public void reverseString() {
		String name = "Mohan";
		StringBuffer sb = new StringBuffer(name);
		System.out.println(sb.reverse());
	}
	@Test
	public void swapTwoStrings() {
		String name = "Mohan";
		String name1 = "Reddy";
		
		name = name + name1;
		name1= name.substring(0, name.length()-name1.length());
		name = name.substring(name1.length());
		System.out.println(name);
		System.out.println(name1);
	}
	@Test
	public void fibonacci() {
		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int maxNum = sc.nextInt();
		int first = 0, second = 1;
		for(int i =0; i<maxNum; i++) {
			System.out.println(first);
			int next = first + second;
			first = second;
			second = next;
		}
	}
	@Test
	public void armStrong() {
		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int res=0;
		int countOfnum = String.valueOf(num).length();
		while(num>0) {
			int temp = num%10;
			res += (int) Math.pow(temp, countOfnum);
//			System.out.println(res);
			num = num/10;
		}
		System.out.println(res);
	}
	@Test
	public void sumOfDigits() {
		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int res=0;
		while (num>0) {
			res+=num%10;
			num/=10;
		}
		System.out.println(res);
	}

	@Test
	public void countOfLetters() {
		System.out.print("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
			else {
				map.put(str.charAt(i), 1);
			}
		}
		System.out.println(map);
	}
	@Test
	public void reverseAnArray() {
		char [] arr = { 'a', 'b', 'c', 'd', 'e' };
		int start=0, end=arr.length-1;
		while(start<end) {
			char temp=arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		System.out.println(arr);
	}
	@Test
	public void productOfAnArrayExceptSelf() {
		int[] nums = {1, 2, 3, 4};
		int[] res = new int[nums.length];
		
		for(int i=0; i<nums.length; i++) {
			res[i] = 1;
			for(int j=0;j<nums.length;j++) {
				if(i!=j) {
					res[i] *=nums[j];
				}
			}
		}
		for(int i: res) {
			System.out.println(i);
		}
	}
}
