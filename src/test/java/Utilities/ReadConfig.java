package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig()  {

		try {
			prop = new Properties();
			File file = new File("./Configuration//config.properties");
			FileInputStream input = new FileInputStream(file);
			prop.load(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public String getFirstname() {
		String firstname=prop.getProperty("firstname");
		return firstname;
		
	}
	public String getLastname() {
		String lastname=prop.getProperty("lastname");
		return lastname;
	}
	public String getUrl() {
		String url=prop.getProperty("loginurl");
		return url;
		
	}
	public List<String> getExpectedContinents(){
		String temp=prop.getProperty("continents");
		List<String> ls = new ArrayList<String>();
		for(String s:temp.split(",")) {
			ls.add(s);
		}
		return ls;
	}
	public List<String>getExpectedMultiContinents(){
		String temp=prop.getProperty("Multiple");
		List<String>lp=new ArrayList<String>();
		for(String p:temp.split(",")) {
			lp.add(p);
		}
		return lp;
	}
}
