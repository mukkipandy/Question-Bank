package com.interview.gs;

public class _04_Second_Smallest {

  /**
   * int secondSmallest(int[] x)
   */
  public static int secondSmallest(int[] x) {
    // Your code
    if (x.length < 1) {
      return 0;
    }
    if (x.length < 2) {
      return x[0];
    }

    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;

    for (int i = 0; i < x.length; i++) {
      if (x[i] <= min) {
        secondMin = min;
        min = x[i];
      } else if (x[i] < secondMin) {
        secondMin = x[i];
      }
    }
    return secondMin;
  }

  public static void main(String args[]) {

    int[] a = {0};
    int[] b = {0, 1};
    int[] c = {5, 6, 7, 3, 12, 8, 9, 2};

    boolean result = true;
    result &= secondSmallest(a) == 0;
    result &= secondSmallest(b) == 1;
    result &= secondSmallest(c) == 3;

    if (result) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }

  }

}
