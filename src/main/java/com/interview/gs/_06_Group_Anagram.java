package com.interview.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This program prints set of anagrams together in given string 
 * 
 * eg. 
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

public class _06_Group_Anagram {

	static void setOfAnagrams(String inputString) {

		// your code goes here
		Map<String, ArrayList<String>> anagram = new HashMap<>();

		String[] words = inputString.split(" ");
		for (String word : words) {
			char[] wArr = word.toCharArray();
			Arrays.sort(wArr);
			String sortedString = new String(wArr);

			if (!anagram.containsKey(sortedString)) {
				anagram.put(sortedString, new ArrayList<String>());
			}
			anagram.get(sortedString).add(word);
		}

		for (List<String> anagramList : anagram.values()) {
			for (String word : anagramList) {
				System.out.print(word + " ");
			}
		}
	}

	public static void main(String[] args) {
		String input = "cat dog tac sat tas god dog";
		setOfAnagrams(input);
	}

}
