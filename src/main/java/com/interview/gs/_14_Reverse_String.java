package com.interview.gs;

public class _14_Reverse_String {

  /**
   * public static String reverseStr( String str ) Example: reverseStr(str) where str is "abcd"
   * returns "dcba".
   */
  public static String reverseStr(String str) {
    // your code goes here
    StringBuilder sb = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  ;

  public static void main(String[] args) {

    boolean result = true;

    result = result && reverseStr("abcd").equals("dcba");

    if (result) {
      System.out.println("All tests pass");
    } else {
      System.out.println("There are test failures");
    }

  }

}
