package JavaLearn;

import org.testng.annotations.Test;

public class SwapTwoNumsWithoutThirdVar {
	@Test
	public void test() {
		int a =5;
		int b = 7;
		
		a = a+b;
		System.out.println("value of a: "+a);
		b = a-b;
		System.out.println("value of a: "+a);
		System.out.println("value of v: "+b);
		a = a-b;
		System.out.println("value of a: "+a);
		System.out.println("after swapping a = " +a+" and b = "+b);
	}
}
