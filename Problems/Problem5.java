package com.euler;

/**
 * Smallest multiple
 * 
 * Problem 5
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 *
 */
public class Problem5 {
	public static void main(String[] args) {

		for (long i = 1; i < Long.MAX_VALUE; i++) {
			if (checkDivisiblebyAll20(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean checkDivisiblebyAll20(long num) {
		for (int i = 2; i <= 20; i++)
			if (num % i != 0)
				return false;
		return true;
	}
}
