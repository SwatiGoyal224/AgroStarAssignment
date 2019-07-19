package Assignment.Assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertyReader {
	
	private Properties properties;
	private final String propertyFilePath= "/Users/sgoyal/Documents/AgroStar/AgroStarAssignment/Assignment/src/main/resources/Properties/TestData.properties";

	
	public PropertyReader(){
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
	
	public String getItem() {
		String item=properties.getProperty("item");
		if(item!= null) return item;
		else throw new RuntimeException("Item not specified in the properties file.");		
	}
	
	public String getUserName() {
		String username=properties.getProperty("username");
		if(username!= null) return username;
		else throw new RuntimeException("Username not specified in the properties file.");		
	}
	
	public String getPassWord() {
		String password=properties.getProperty("password");
		if(password!= null) return password;
		else throw new RuntimeException("Password not specified in the properties file.");		
	}
	
	public String getPincode() {
		String pincode=properties.getProperty("Pincode");
		if(pincode!= null) return pincode;
		else throw new RuntimeException("Pincode not specified in the properties file.");		
	}
	
	public String getAddress1() {
		String address1=properties.getProperty("Address1");
		if(address1!= null) return address1;
		else throw new RuntimeException("Address1 not specified in the properties file.");		
	}
	
	public String getAddress2() {
		String address2=properties.getProperty("Address2");
		if(address2!= null) return address2;
		else throw new RuntimeException("Address2 not specified in the properties file.");		
	}
	
	public String getCity() {
		String city=properties.getProperty("City");
		if(city!= null) return city;
		else throw new RuntimeException("City not specified in the properties file.");		
	}
	
	public String getState() {
		String state=properties.getProperty("State");
		if(state!= null) return state;
		else throw new RuntimeException("State not specified in the properties file.");		
	}

}
