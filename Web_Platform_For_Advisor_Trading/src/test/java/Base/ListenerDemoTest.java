package Base;
import org.testng.Assert;
import org. testng. annotations. Test;

public class ListenerDemoTest extends BaseTest{
	@Test
	public void launchApp() {
		driver.get("https://ebay.com");
		Assert.assertTrue(false);
	}
}
