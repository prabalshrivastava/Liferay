package com.sambaash.platform.enquiry;

public class CapitalizeCharacter {

	public static String humanize(String inputString) {
		inputString = splitCamelCase(inputString);
		String outputString = inputString.substring(0, 1).toUpperCase() + inputString.substring(1);
		return outputString.trim();
	}

	static String splitCamelCase(String s) {
		return s.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
				"(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
	}
}
