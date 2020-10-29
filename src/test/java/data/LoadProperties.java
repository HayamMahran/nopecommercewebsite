package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
 
	//Load Properties File from the folder
	
	public static Properties userdata = loadProperties(System.getProperty("user.dir")+
			"\\src\\main\\java\\proerties\\userdata.properties");
	
	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		//stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			try {
				pro.load(stream);
			} catch (IOException e) {
				System.out.println("Error occurred : "+ e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred : "+ e.getMessage());
		}
		return pro;
	}
	
}
