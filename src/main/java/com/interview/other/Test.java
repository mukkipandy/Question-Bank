package com.interview.other;

import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		Stream.iterate(0, n -> n + 2).forEach(n -> System.out.print(n + ", "));

		/*
		 * Runnable basic = () -> { String threadName =
		 * Thread.currentThread().getName();
		 * System.out.println("Running common task by " + threadName); };
		 * 
		 * // Instantiating two thread classes Thread thread1 = new Thread(basic);
		 * Thread thread2 = new Thread(basic);
		 * 
		 * // Running two threads for the same task thread1.start(); thread2.start();
		 */
	}
}
