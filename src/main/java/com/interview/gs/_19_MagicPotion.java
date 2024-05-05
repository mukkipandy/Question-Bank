package com.interview.gs;

/*
Question: 
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following  
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode

*/

public class _19_MagicPotion {

	private static int encodeString(String inputString) {
		int n = inputString.length();
		if (n == 0) {
			return 0;
		}
		StringBuilder magicPotion = new StringBuilder();
		// add first character
		magicPotion.append(inputString.charAt(0));

		for (int i = 1; i < n; i++) {

			if (i * 2 <= n) {
				String stringToCompare = inputString.substring(0, i);

				if (stringToCompare.equals(inputString.substring(i, 2 * i))) {
					magicPotion.append("*");
					i = 2 * i - 1; // a -1 here as there is already a ++i in for loop
				} else {
					magicPotion.append(inputString.charAt(i));
				}
			} else { // i*2 has crossed n, simply add the characters
				magicPotion.append(inputString.charAt(i));
			}
		}
		System.out.println(inputString + "\t" + magicPotion);

		return magicPotion.length();

	}

	public static void main(String[] args) {

		if (encodeString("ABABCABABCE") == 6 && encodeString("ABCABCE") == 5) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
