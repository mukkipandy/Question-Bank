package com.interview.gs;

/**
 * Implement power(base,exp) correctly. Assume exp is an integer.
 */

public class _00_Power {

  /*
   * Given base and integer exponent, compute value of base raised to the power of
   * exponent. Can you implement a solution faster than O(exp)?
   */
  public static double powerEfficient(double base, int exponent) {
    if (exponent < 0) {
      throw new IllegalArgumentException("Exponent must be non-negative");
    }
    if (exponent == 0 || base == 1) {
      return 1;
    } else if (exponent == 1) {
      return base;
    } else {
      double halfPower = powerEfficient(base, exponent / 2);
      if (exponent % 2 == 0) {
        // If exponent is even, square the half power
        return halfPower * halfPower;
      } else {
        // If exponent is odd, square the half power and multiply by the base
        return base * halfPower * halfPower;
      }
    }
  }

  public static double power(double base, int exp) {
    if (exp == 0 || base == 1) {
      return 1;
    }
    double temp = base;
    while (exp > 1) {
      base = base * temp;
      exp--;
    }
    return base;
  }

  /* returns true if all tests pass, false otherwise */
  public static boolean doTestsPass() {
    boolean doTestsPass = (powerEfficient(4, 3) == 64.0);
    doTestsPass = (doTestsPass) && (powerEfficient(2, 4) == 16.0);
    doTestsPass = (doTestsPass) && (powerEfficient(5, 3) == 125.0);
    doTestsPass = (doTestsPass) && (powerEfficient(7, 2) == 49.0);
    return doTestsPass;
  }

  public static void main(String[] args) {
    if (doTestsPass()) {
      System.out.println("All Tests Pass");
    } else {
      System.out.println("There are test failures");
    }
  }

}
