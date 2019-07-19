package Assignment.Assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class APIPropertyReader {
	
	private Properties properties;
	private final String propertyFilePath= "/Users/sgoyal/Documents/AgroStar/AgroStarAssignment/Assignment/src/main/resources/Properties/APITestData.properties";

	
	public APIPropertyReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getAuthToken() {
		String authToken=properties.getProperty("AuthToken");
		if(authToken!= null) return authToken;
		else throw new RuntimeException("Item not specified in the properties file.");		
	}
	
	public String getUserName() {
		String username=properties.getProperty("username");
		if(username!= null) return username;
		else throw new RuntimeException("Username not specified in the properties file.");		
	}
	
	

}
