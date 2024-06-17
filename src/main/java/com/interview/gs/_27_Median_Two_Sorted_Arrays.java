package com.interview.gs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _27_Median_Two_Sorted_Arrays {

  public static double findMedian(int[] array1, int[] array2) {

    List<Integer> myList = new ArrayList<>();
    for (int i = 0; i < array1.length; i++) {
      myList.add(array1[i]);
    }

    for (int i = 0; i < array2.length; i++) {
      myList.add(array2[i]);
    }

    myList = myList.stream().sorted().collect(Collectors.toList());

    int lenght = myList.size();
    int medianIndex = 0;
    double median;
    if (lenght % 2 == 0) {
      medianIndex = lenght / 2;
      median = (myList.get(medianIndex) + myList.get(medianIndex - 1)) / 2.0;
    } else {
      medianIndex = lenght / 2;
      median = myList.get(medianIndex);
    }
    System.out.print(median);
    return median;
  }

  public static boolean pass() {
    boolean result = true;
    result = result && findMedian(new int[]{1, 3}, new int[]{2, 4, 5}) == 2.5;
    return result;
  }

  public static void main(String[] args) {
    if (pass()) {
      System.out.println("pass");
    } else {
      System.out.println("some failures");
    }
  }
}
