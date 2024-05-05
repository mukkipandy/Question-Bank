package com.interview.gs;

//Java program to check if a number is power of
//another number
public class PoweOfAnotherNumber {
	// driver method to test power method
	public static void main(String[] args) {
		// check the result for true/false and print.
		System.out.println(isPower(10, 1) ? 1 : 0);
		System.out.println(isPower(1, 20) ? 1 : 0);
		System.out.println(isPower(2, 128) ? 1 : 0);
		System.out.println(isPower(2, 30) ? 1 : 0);
	}

	/* Returns true if y is a power of x */
	public static boolean isPower(int x, int y) {
		// The only power of 1 is 1 itself
		if (x == 1)
			return (y == 1);

		// Repeatedly compute power of x
		int pow = 1;
		while (pow < y)
			pow = pow * x;

		// Check if power of x becomes y
		return (pow == y);
	}
}

//This code is contributed by Jyotsna.
