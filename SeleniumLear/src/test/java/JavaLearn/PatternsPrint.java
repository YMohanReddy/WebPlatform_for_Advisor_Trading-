package JavaLearn;


import org.testng.annotations.Test;

public class PatternsPrint {

	@Test
	public void leftAngleTriangle() {
		int rows = 4;
		for(int i=1; i<=rows; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	@Test
	public void rightAngleTriangle() {
		int rows = 6;
		for(int i=1; i<=rows; i++) {
			for(int j=0; j<rows-i; j++) {
				System.out.print("  ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	@Test
	public void pyramidStarPattern() {
		int rows = 6;
		for(int i=1; i<=rows; i++) {
			for(int j=0; j<rows-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	@Test
	public void dimond() {
		int rows=6;
		for(int i=1; i<=rows; i++) {
			for(int j=0; j<rows-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=0; i<rows; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<rows-i-1; j++) {
				System.out.print(" *");
			}
			
			System.out.println();
		}
	}
	@Test
	public void downwardTriangle() {
		int rows=7;
		for(int i=0; i<=rows; i++) {
			for(int j=0; j<rows-i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	@Test
	public void mirroredRightTriangle() {
		int rows=6;
		for(int i=1; i<=rows; i++) {
			for(int j=0; j<rows-i;j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	@Test
	public void reversePyramid() {
		int rows =6;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < rows-i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	@Test
	public void rightDownMirrorStarPattern() {
		int rows = 6;
		for (int i=0; i<rows; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < rows-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	@Test
	public void sandGlass(){
		int rows=6;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < rows-i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < rows-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	@Test
	public void starTriangle() {
		int rows=6;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows-i; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 0; j < i*2-1; j++) {
				System.out.print(" ");
			}
			if(i>0) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i <=  rows; i++) {
	        System.out.print("* ");
	    }
		System.out.println();
	}
}
