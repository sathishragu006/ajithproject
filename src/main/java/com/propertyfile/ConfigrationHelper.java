package com.propertyfile;

import java.io.IOException;

public class ConfigrationHelper {

	public static  ConfigurationReader getInstance() throws IOException {
		ConfigurationReader cr = new ConfigurationReader();
		return cr;
	}
	private  ConfigrationHelper() {



}}
