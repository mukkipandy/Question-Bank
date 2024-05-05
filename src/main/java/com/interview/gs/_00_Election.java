package com.interview.gs;

/**
 * A group of students are sitting in a circle. The teacher is electing a new
 * class president. The teacher does this by singing a song while walking around
 * the circle. After the song is finished the student at which the teacher
 * stopped is removed from the circle.
 *
 * Starting at the student next to the one that was just removed, the teacher
 * resumes singing and walking around the circle. After the teacher is done
 * singing, the next student is removed. The teacher repeats this until only one
 * student is left.
 *
 * A song of length k will result in the teacher walking past k students on each
 * round. The students are numbered 1 to n. The teacher starts at student 1.
 *
 * For example, suppose the song length is two (k=2). And there are four
 * students to start with (1,2,3,4). The first student to go would be `2`, after
 * that `4`, and after that `3`. Student `1` would be the next president in this
 * example.
 *
 * @param n the number of students sitting in a circle.
 * @param k the length (in students) of each song.
 * @return the number of the student that is elected.
 */
public class _00_Election {

	public static int findElectedStudent(int n, int k) {
		if (n <= 0 || k <= 0) {
			throw new IllegalArgumentException("n and k must be positive integers");
		}

		// Create an array to represent the students, initialize them from 1 to n.
		int[] students = new int[n];
		for (int i = 0; i < n; i++) {
			students[i] = i + 1;
		}

		int currentIndex = 0; // Start with the first student
		while (n > 1) {
			// Calculate the index of the student to be removed
			currentIndex = (currentIndex + k - 1) % n;

			// Remove the student at the currentIndex
			for (int i = currentIndex; i < n - 1; i++) {
				students[i] = students[i + 1];
			}

			n--; // Decrement the number of students
		}

		// Return the number of the last remaining student
		return students[0];
	}

	/**
	 * bool doTestsPass() Runs various tests. Returns true if tests pass. Otherwise,
	 * returns false.
	 */
	public static boolean doTestsPass() {
		// todo: implement more tests, please
		// feel free to make testing more elegant
		// test cases are structered as {n, k, expected answer}
		int[][] testCases = {{ 14, 2, 13 }, { 1, 1, 1 }, { 2, 2, 1 }, { 4, 2, 1 }, { 100, 2, 73 }, { 5, 3, 4 }, { 6, 4, 5 },
				{ 1000, 5, 763 } };

		int[][] testCasess = { { 4, 2, 4 }, { 6, 4, 5 } };

		for (int[] testCase : testCases) {
			int answer = findElectedStudent(testCase[0], testCase[1]);
			if (answer != testCase[2]) {
				System.out.println("test failed!");
				System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer,
						testCase[2]);
				return false;
			}
		}
		System.out.println("All tested passed");
		return true;
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String args[]) {
		doTestsPass();
	}

}
