package com.euler;

/**
 * Longest Collatz sequence
 * 
 * Problem 14
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even) n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this sequence
 * (starting at 13 and finishing at 1) contains 10 terms. Although it has not
 * been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem14 {

	public static void main(String[] args) {
		findLargestSequence(1_000_000);
	}

	private static long findLargestSequence(long n) {
		long maxCount = Long.MIN_VALUE;
		long num = 0;
		for (long i = 2; i <= n; i++) {
			long count = collatz_sequence(i);
			if (maxCount < count) {
				maxCount = count;
				num = i;
				//System.out.println("Max Number seq " + num + " Count " + maxCount);
			}
		}

		System.out.println("Max Number seq " + num + " Count " + maxCount);
		return maxCount;
	}

	private static long collatz_sequence(long i) {
		int count = 0;
		while (i != 1) {
			if (i % 2 == 0)
				i /= 2;
			else
				i = 3 * i + 1;
			count++;
		}

		return count;
	}

}
