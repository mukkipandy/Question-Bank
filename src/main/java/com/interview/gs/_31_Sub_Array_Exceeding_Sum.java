package com.interview.gs;

public class _31_Sub_Array_Exceeding_Sum {

  public static int findSmallestSubarray(int[] arr, int x) {
    int n = arr.length;
    int minLength = n + 1; // Initialize the minimum length as a large number.
    int sum = 0; // Initialize the current sum.
    int start = 0; // Initialize the left pointer of the subarray.

    for (int end = 0; end < n; end++) {
      // Add the current element to the sum.
      sum += arr[end];

      // Check if the current sum exceeds x.
      while (sum > x) {
        // Update the minimum length if necessary.
        minLength = Math.min(minLength, end - start + 1);

        // Remove the leftmost element from the subarray.
        sum -= arr[start];
        start++;
      }
    }

    // If minLength is still greater than n, no subarray was found.
    if (minLength > n) {
      return -1;
    }

    return minLength;
  }

  public static void main(String[] args) {
    int[] arr = {1, 4, 45, 6, 0, 19};
    int x = 51;
    int minLength = findSmallestSubarray(arr, x);

    if (minLength == -1) {
      System.out.println("No subarray found with sum greater than " + x);
    } else {
      System.out.println(
          "Smallest subarray length with sum greater than " + x + " is " + minLength);
    }
  }

}
