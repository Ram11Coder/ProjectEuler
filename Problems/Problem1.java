package com.euler;

/**
 * Multiples of 3 or 5 Problem 1 If we list all the natural numbers below 10
 * that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
 * multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * 
 */
public class Problem1 {

	public static void main(String[] args) {
		long sum = 0;
		long n = 1_234_567_89;
		for (long i = 3; i < n; i++)
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;

		System.out.println(sum);

		// Without loop(Optimised)-> Hack is AP(Arithmetic progression)
		System.out.println();

		long three, five, fifteen, c;
		c = (n % 3 == 0) ? (n / 3) - 1 : n / 3;
		three = (c * (6 + (c - 1) * 3)) / 2;
		c = (n % 5 == 0) ? (n / 5) - 1 : n / 5;
		five = (c * (10 + (c - 1) * 5)) / 2;
		c = (n % 15 == 0) ? (n / 15) - 1 : n / 15;
		fifteen = (c * (30 + (c - 1) * 15)) / 2;
		System.out.println((three + five) - fifteen);
	}

}
