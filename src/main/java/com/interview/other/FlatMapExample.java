package com.interview.other;

import java.util.ArrayList;
import java.util.List;

public class FlatMapExample {
	public static int flattenAndSum(List<List<Integer>> listOfLists) {
		return listOfLists.stream().flatMap(List::stream) // Flatten the list of lists into a single stream of integers
				.mapToInt(Integer::intValue) // Convert the stream of Integers to IntStream
				.sum(); // Compute the sum of all integers
	}

	public static void main(String[] args) {
		
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(List.of(1, 2, 3));
        listOfLists.add(List.of(4, 5));
        listOfLists.add(List.of(6, 7, 8));



		int sum = flattenAndSum(listOfLists);

		System.out.println("Flattened list: " + listOfLists);
		System.out.println("Sum of all integers: " + sum);
	}
}
