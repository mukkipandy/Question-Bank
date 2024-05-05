package com.interview.gs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Given a jumbled collection of segments, each of which is represented as a
 * Pair(startPoint, endPoint), this function sorts the segments to make a
 * continuous path.
 *
 * A few assumptions you can make: 1. Each particular segment goes in one
 * direction only, i.e.: if you see (1, 2), you will not see (2, 1). 2. Each
 * starting point only have one way to the end point, i.e.: if you see (6, 5),
 * you will not see (6, 10), (6, 3), etc.
 *
 * For example, if you're passed a list containing the following int arrays:
 * [(4, 5), (9, 4), (5, 1), (11, 9)] Then your implementation should sort it
 * such: [(11, 9), (9, 4), (4, 5), (5, 1)]
 *
 * @param segments collection of segments, each represented by a
 *                 Pair(startPoint, endPoint).
 * @return The sorted segments such that they form a continuous path.
 * @throws Exception if there is no way to create one continuous path from all
 *                   the segments passed into this function. Feel free to change
 *                   the Exception type as you think appropriate.
 */
class _05_SortSegments {
	static class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static class CustomComparator implements java.util.Comparator<Integer> {
		@Override
		public int compare(Integer x, Integer y) {
			return Integer.compare(y, x);
		}
	}

	public static List<Pair> sortSegment(List<Pair> pArray) {
		Map<Integer, Integer> myMap = new TreeMap<>(Comparator.reverseOrder());

		for (Pair pair : pArray) {
			myMap.put(pair.first, pair.second);
		}

		pArray.clear();
		Entry<Integer, Integer> start = myMap.entrySet().iterator().next();
		pArray.add(new Pair(start.getKey(), start.getValue()));
		myMap.remove(start.getKey());

		while (!myMap.isEmpty()) {
			Pair p = pArray.get(pArray.size() - 1);
			Integer nextKey = p.second;
			Integer nextValue = myMap.get(nextKey);

			if (nextValue != null) {
				pArray.add(new Pair(nextKey, nextValue));
				myMap.remove(nextKey);
			} else {
				// Not found
				break;
			}
		}
		return pArray;
	}

	public static void main(String[] args) {
		List<Pair> pArray = new ArrayList<>();
		pArray.add(new Pair(4, 5));
		pArray.add(new Pair(9, 4));
		pArray.add(new Pair(5, 1));
		pArray.add(new Pair(11, 9));

		List<Pair> arr = sortSegment(pArray);
		for (Pair pair : arr) {
			System.out.println("<" + pair.first + ", " + pair.second + ">");
		}

		List<Pair> jumbledSegments = new ArrayList<>();
		jumbledSegments.add(new Pair(4, 5));
		jumbledSegments.add(new Pair(9, 4));
		jumbledSegments.add(new Pair(5, 1));
		jumbledSegments.add(new Pair(11, 9));

		List<Pair> actualContinuousPath = sortSegment(jumbledSegments);

		List<Pair> expectedContinuousPath = new ArrayList<>();
		expectedContinuousPath.add(new Pair(11, 9));
		expectedContinuousPath.add(new Pair(9, 4));
		expectedContinuousPath.add(new Pair(4, 5));
		expectedContinuousPath.add(new Pair(5, 1));

	}
}
