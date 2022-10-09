package com.propertyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	private Properties p;

	public ConfigurationReader() throws IOException {
		File f = new File(
				"C:\\Users\\Sathish\\eclipse-workspace\\demo\\src\\main\\java\\com\\propertyfile\\property.properties");

		FileInputStream fi = new FileInputStream(f);

		p = new Properties();

		p.load(fi);

	}

	public String getBrowser() {

		String browser = p.getProperty("browser");
		return browser;
	}

	public String getUrl() {

		String url = p.getProperty("url");
		return url;
	}

	public String getUsername() {

		String name = p.getProperty("username");
		return name;
	}

	public String getPassword() {

		String url = p.getProperty("password");
		return url;
	}
}
