package TestPkge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws Exception {
		FileInputStream file =  new FileInputStream(System.getProperty("user.dir")+"\\DDF.properties");
		Properties properties = new Properties();
		properties.load(file);
		
		System.out.println(properties.getProperty("URL"));
		String path=System.getProperty("user.dir")+properties.getProperty("TestDataPath");
		System.out.println(path);
		
	}

}
