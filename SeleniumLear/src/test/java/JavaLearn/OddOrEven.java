package JavaLearn;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String result = (num%2==0) ? "Even" : "Odd";
		
		System.out.println("Give number is " + result);
	}

}
