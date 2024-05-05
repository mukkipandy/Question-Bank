package com.interview.other;

public class Codility {

	public static void main(String[] args) {
		int[] A = { 1, -2, -3, 5 };
		int output = solution(A);
		System.out.println(output);
	}

	public static int solution(int[] A) {

		boolean isNegativeProduct = false;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				return 0;
			} else if (A[i] < 0) {
				isNegativeProduct = !isNegativeProduct;
			}
		}
		if (isNegativeProduct) {
			return -1;
		} else {
			return 1;
		}
	}
}
