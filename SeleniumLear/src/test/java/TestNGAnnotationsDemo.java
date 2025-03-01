import org.testng.annotations.*;

public class TestNGAnnotationsDemo {
/*
 * Explanation of the Flow
@BeforeSuite → Runs once before the entire test suite.
@BeforeTest → Runs once before any test methods in the <test> tag in testng.xml.
@BeforeClass → Runs once before any test methods in the current class.
@BeforeMethod → Runs before every test method.
@Test → Test methods execute between @BeforeMethod and @AfterMethod.
@AfterMethod → Runs after every test method.
@AfterClass → Runs once after all test methods** in the class.
@AfterTest → Runs once after all test methods** in the <test> tag.
@AfterSuite → Runs once after the entire test suite.

 */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite - Runs before the entire test suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest - Runs before any test method in the test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass - Runs once before the first test method in the class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod - Runs before each test method");
    }

    @Test
    public void testMethod1() {
        System.out.println("@Test - Executing Test Method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("@Test - Executing Test Method 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod - Runs after each test method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass - Runs once after all test methods in the class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest - Runs after all test methods in the test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite - Runs after the entire test suite");
    }
} 
