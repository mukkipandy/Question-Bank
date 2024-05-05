package com.interview.gs;

import java.util.Set;
import java.util.stream.Collectors;

public class _02_Panagram {
	public static String findMissingLetters(String input) {
		
		Set<Character> inputChar = input.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

		StringBuilder sb = new StringBuilder();
		for (char c = 'a'; c <= 'z'; c++) {
			if (!inputChar.contains(c)) {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		boolean success = true;

		success = success && "".equals(findMissingLetters("The quick brown fox jumps over the lazy dog"));
		success = success && "abcdefghijklmnopqrstuvwxyz".equals(findMissingLetters(""));

		if (success) {
			System.out.println("Pass ");
		} else {
			System.out.println("Failed");
		}
	}

}
