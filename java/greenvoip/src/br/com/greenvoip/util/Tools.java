package br.com.greenvoip.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Tools {
	
	private static final String CONFIG_FILE = "conf.config";

	public String getParameter(String parameter) {
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("conf.config");
			return resourceBundle.getString(parameter);
		} catch (MissingResourceException e) {
			System.err.println("Was not possible to find configuration file: " + CONFIG_FILE);
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer getIntegerParameter(String parameter) {
		try {
			return Integer.parseInt(getParameter(parameter));
		} catch (NumberFormatException e) {
			System.err.println("Impossible to convert parameter '" + parameter + "' to Integer.");
			System.err.println("Returning 0.");
			return 0;
		}
	}
}
