import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class readWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("C:\\Users\\ybhas\\eclipse-workspace\\SeleniumLear\\src\\test\\resources\\testData.properties");
		properties. load(inputstream);
		System.out.println(properties.getProperty("browser"));
		System.out.println(properties. getProperty("url") );


		FileOutputStream outputstream = new FileOutputStream("C:\\Users\\ybhas\\eclipse-workspace\\SeleniumLear\\src\\test\\resources\\testData.properties");
		properties. store (outputstream, "This is customer data from TC2");

	}

}
