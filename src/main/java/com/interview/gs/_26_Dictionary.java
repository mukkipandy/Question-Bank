package com.interview.gs;

import java.util.ArrayList;
import java.util.List;

public class _26_Dictionary {

	public static List<String> longestWord(String letters, String[] dictionary) {
		List<String> result = new ArrayList<>();
		int maxLength = 0;

		for (String word : dictionary) {
			if (canBeFormed(letters, word)) {
				if (word.length() > maxLength) {
					maxLength = word.length();
					result.clear();
					result.add(word);
				} else if (word.length() == maxLength) {
					result.add(word);
				}
			}
		}

		return result;
	}

	private static boolean canBeFormed(String letters, String word) {
		
		int[] letterCounts = new int[26];

		for (char c : letters.toCharArray()) {
			letterCounts[c - 'a']++;
		}

		for (char c : word.toCharArray()) {
			if (letterCounts[c - 'a'] == 0) {
				return false;
			}
			letterCounts[c - 'a']--;
		}

		return true;
	}
	
	


	public static void main(String[] args) {
		String letters = "eost";
		String[] dictionary = { "do", "to", "toe", "toes" };

		List<String> longestWords = longestWord(letters, dictionary);

		if (longestWords.isEmpty()) {
			System.out.println("No valid words found.");
		} else {
			System.out.println("Longest word(s) that can be formed: " + longestWords);
		}
	}

}
