package com.interview.gs;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Finds the first character that does not repeat anywhere in the input string
 * Given "apple", the answer is "a" Given "racecars", the answer is "e"
 **/
public class _11_First_Non_Repeating {

	public static char findNonRepeat(String input) {
		Map<Character, Boolean> myMap = new LinkedHashMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			char x = input.charAt(i);
			if (myMap.containsKey(x)) {
				myMap.put(x, false);
			} else {
				myMap.put(x, true);
			}
		}

		Character firstNonRepeat = null;
		for (Map.Entry<Character, Boolean> entry : myMap.entrySet()) {
			if (entry.getValue()) {
				firstNonRepeat = entry.getKey();
				break;
			}
		}
		return firstNonRepeat;

	}

	public static void main(String[] args) {

		String[] inputs = { "apple", "racecars", "ababdc" };
		char[] outputs = { 'a', 'e', 'd' };

		boolean result = true;
		for (int i = 0; i < inputs.length; i++) {
			result = result && findNonRepeat(inputs[i]) == outputs[i];
			if (!result)
				System.out.println("Test failed for: " + inputs[i]);
			else
				System.out.println("Test passed for: " + inputs[i]);
		}
	}

}
