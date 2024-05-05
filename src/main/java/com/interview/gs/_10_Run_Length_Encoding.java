package com.interview.gs;

public class _10_Run_Length_Encoding {

	public static String rle(String input) {
		if (input == null || input.length() == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		int count = 1;

		for (int i = 0; i < input.length() - 1; i++) {
			if (count == 1) {
				sb.append(input.charAt(i));
			}
			if (input.charAt(i) == input.charAt(i + 1)) {
				count++;
			} else {
				sb.append(count);
				count = 1;
			}
		}
		if (count == 1) {
			sb.append(input.charAt(input.length() - 1));
		}
		sb.append(count);

		return sb.toString();
	}

	public static void main(String[] args) {

		if ("".equals(rle("")) && "a1".equals(rle("a")) && "a3".equals(rle("aaa"))) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

}
