package JavaLearn;

import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class RegEx {

	@Test
	public void check() {
		String str = "Mohan";
		System.out.println(Pattern.matches("M[a-z]han", str));
	}
	
	@Test
	public void patterCheck() {
		String str = "abcABC123";
		System.out.println(Pattern.matches("a[a-z]{2}[A-Z]{3}12[1-4]", str));
		
	}
}
