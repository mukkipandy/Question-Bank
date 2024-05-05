package com.interview.gs;

public class FibonacciSeries {

	// Recursive method to find the nth Fibonacci number
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static void main(String[] args) {
		int n = 10; // Change this value to the desired number of Fibonacci numbers
		System.out.println("Fibonacci Series up to " + n + " terms:");
		for (int i = 0; i < n; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}
}

class FibonacciIterative {

	public static void main(String[] args) {
		int n = 10; // Change this value to the desired number of Fibonacci numbers
		System.out.println("Fibonacci Series up to " + n + " terms:");
		int[] fibonacciSeries = new int[n];

		fibonacciSeries[0] = 0;
		fibonacciSeries[1] = 1;

		for (int i = 2; i < n; i++) {
			fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
		}

		for (int i = 0; i < n; i++) {
			System.out.print(fibonacciSeries[i] + " ");
		}
	}
}
