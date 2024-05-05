package com.interview.gs;

import java.util.LinkedList;
import java.util.List;

public class JosephusProblem {

	public static int findLastPerson(int n, int k) {
		List<Integer> people = new LinkedList<>();

		// Initialize the list of people
		for (int i = 1; i <= n; i++) {
			people.add(i);
		}

		int index = 0;

		while (people.size() > 1) {
			// Find the position of the person to be removed
			index = (index + k - 1) % people.size();

			// Remove the person at the calculated position
			people.remove(index);
		}

		// Return the position of the last person standing
		return people.get(0);
	}

	public static void main(String[] args) {
		int n = 14; // Total number of people
		int k = 2; // Elimination step size

		int lastPerson = findLastPerson(n, k);
		System.out.println("The last person standing is at position: " + lastPerson);
	}
}
