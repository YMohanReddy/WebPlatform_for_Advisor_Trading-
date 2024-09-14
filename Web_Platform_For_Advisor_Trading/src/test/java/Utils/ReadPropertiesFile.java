package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr = new FileReader("C:\\Users\\ybhas\\eclipse-workspace\\Web_Platform_For_Advisor_Trading\\src\\test\\resources\\configFile\\Config.properties");
		
		Properties properties = new Properties();
		properties.load(fr);
		properties.getProperty("browser");

	}

}
