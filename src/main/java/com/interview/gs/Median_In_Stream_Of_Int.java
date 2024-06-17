package com.interview.gs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Median_In_Stream_Of_Int {

  private Queue<Integer> minHeap, maxHeap;

  Median_In_Stream_Of_Int() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  public static void main(String[] args) {
    int[] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
    Median_In_Stream_Of_Int median = new Median_In_Stream_Of_Int();

    for (int i = 0; i < arr.length; i++) {
      median.add(arr[i]);
      System.out.print(median.getMedian() + ", ");
    }

  }

  void add(int num) {
    if (!minHeap.isEmpty() && num < minHeap.peek()) {
      maxHeap.offer(num);
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      }
    } else {
      minHeap.offer(num);
      if (minHeap.size() > maxHeap.size() + 1) {
        maxHeap.offer(minHeap.poll());
      }
    }
  }

  double getMedian() {
    int median;
    if (minHeap.size() < maxHeap.size()) {
      median = maxHeap.peek();
    } else if (minHeap.size() > maxHeap.size()) {
      median = minHeap.peek();
    } else {
      median = (minHeap.peek() + maxHeap.peek()) / 2;
    }
    return median;
  }
}