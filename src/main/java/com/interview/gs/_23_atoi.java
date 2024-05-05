package com.interview.gs;

public class _23_atoi {

	// Takes a string str and returns the int value represented by
	// the string.
	// For example, atoi("42") returns 42.

	public static int atoi(String str) {
		int result = 0;
		int strLength = str.length();
		

		if ("".equals(str) || str.matches("[a-zA-Z]+") || str.matches(".*[0-9].*")) {
			return 0;
		}

		for (int i = 0; i < strLength; i++) {
			result = result * 10 + str.charAt(i) - '0';
		}

		return result;
	};

	public static boolean pass() {
		boolean result = true;
		result = result && (atoi("53") == 53);
		result = result && (atoi("1") != 2);

		return result;
	};

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.out.println("Some fail");
		}
	}

}
