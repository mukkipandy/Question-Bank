package com.interview.gs;

class ListNode {

  int val;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
  }
}

public class Nth_Last_element_from_end {

  public static ListNode findNthLastElement(ListNode head, int n) {
    if (head == null || n <= 0) {
      return null;
    }

    ListNode first = head;
    ListNode second = head;

    // Move the first pointer n nodes ahead
    for (int i = 0; i < n; i++) {
      if (first == null) {
        return null; // The list does not have n nodes
      }
      first = first.next;
    }

    // Move both pointers until the first pointer reaches the end
    while (first != null) {
      first = first.next;
      second = second.next;
    }

    return second;
  }

  public static void main(String[] args) {
    // Example usage:
    // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    int n = 2; // Find the 2nd last element
    ListNode nthLastElement = findNthLastElement(head, n);

    if (nthLastElement != null) {
      System.out.println("The " + n + "th last element is: " + nthLastElement.val);
    } else {
      System.out.println("The list does not have an nth last element.");
    }
  }
}
