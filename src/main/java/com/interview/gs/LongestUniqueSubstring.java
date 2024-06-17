package com.interview.gs;

import java.util.HashSet;
import java.util.Set;

class LongestUniqueSubstring {

  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    Set<Character> charSet = new HashSet<>();
    int left = 0;

    for (int right = 0; right < n; right++) {
      if (!charSet.contains(s.charAt(right))) {
        charSet.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);
      } else {
        while (charSet.contains(s.charAt(right))) {
          charSet.remove(s.charAt(left));
          left++;
        }
        charSet.add(s.charAt(right));
      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    String str = "geeksforgeeks";
    System.out.println("The input string is " + str);
    int len = lengthOfLongestSubstring(str);
    System.out.println("The length of " + "the longest non repeating character is " + len);
  }
}