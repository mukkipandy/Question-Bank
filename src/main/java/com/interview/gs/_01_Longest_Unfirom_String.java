package com.interview.gs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * e.g. for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1
 * and is 3 characters long).
 */

public class _01_Longest_Unfirom_String {

  private static final Map<String, int[]> testCases = new HashMap<>();

  static int[] longestUniformSubstring(String input) {
    // your code goes here
    int startIndex = -1;
    int maxLength = 0;
    int count = 1;
    int start = 0;

    if (input != null && input.length() > 0) {
      for (int i = 1; i < input.length(); i++) {
        if (input.charAt(i) == input.charAt(i - 1)) {
          count++;
        } else {
          if (count > maxLength) {
            maxLength = count;
            startIndex = start;
          }
          start = i;
          count = 1;

        }
      }
      if (count > maxLength) {
        maxLength = count;
        startIndex = start;
      }
    }

    return new int[]{startIndex, maxLength};
  }

  public static void main(String[] args) {
    testCases.put("", new int[]{-1, 0});
    testCases.put("10000111", new int[]{1, 4});
    testCases.put("aabbbbbCdAA", new int[]{2, 5});

    boolean pass = true;
    for (Map.Entry<String, int[]> testCase : testCases.entrySet()) {
      int[] result = longestUniformSubstring(testCase.getKey());
      pass = pass && (Arrays.equals(result, testCase.getValue()));
    }
    if (pass) {
      System.out.println("Pass!");
    } else {
      System.out.println("Failed! ");
    }
  }

}
