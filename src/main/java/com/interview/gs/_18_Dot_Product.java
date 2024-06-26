package com.interview.gs;

public class _18_Dot_Product {

  /**
   * Given two arrays of integers, returns the dot product of the arrays
   */

  public static int dotProduct(int[] array1, int[] array2) {
    int ans = 0;
    for (int i = 0; i < array1.length && i < array2.length; i++) {
      ans += array1[i] * array2[i];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] array1 = {1, 2};
    int[] array2 = {2, 3};
    int result = dotProduct(array1, array2);

    if (result == 8) {
      System.out.println("Passed.");
    } else {
      System.out.println("Failed.");
    }
  }
}
