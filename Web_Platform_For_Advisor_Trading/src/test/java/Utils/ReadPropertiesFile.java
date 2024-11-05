package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static String readDataFromPropertiesFile(String Key) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\Config.properties");
		
		Properties properties = new Properties();
		properties.load(fr);
		return properties.getProperty(Key);

	}

}
