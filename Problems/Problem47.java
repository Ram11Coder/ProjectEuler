package com.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The first two consecutive numbers to have two distinct prime factors are:
 * 
 * 14 = 2 × 7 15 = 3 × 5
 * 
 * The first three consecutive numbers to have three distinct prime factors are:
 * 
 * 644 = 2² × 7 × 23 645 = 3 × 5 × 43 646 = 2 × 17 × 19.
 * 
 * Find the first four consecutive integers to have four distinct prime factors
 * each. What is the first of these numbers?
 *
 */
public class Problem47 {
	static List<Long> primes = new ArrayList<Long>();
	static List<Long> consecutiveNumber = new ArrayList<Long>();

	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		/**
		 * Checked the edge case of required number of primes and updated as 150 if 5
		 * distinct prime factor then find out edge case and update in below for loop
		 */
		for (long i = 2, c = 0; c < 150; i++)
			if (isPrime(i)) {
				primes.add(i);
				c++;
			}
		int expectedConsecutive = 4, count = 0;
		for (long i = 2; i < 1_000_000; i++) {
			if (isDivisbleByPrime(i) && consecutiveNumber.size() == expectedConsecutive) {
				count++;
			} else {
				count = 0;
			}
			if (count == expectedConsecutive) {
				System.out.println("Start number : " + (i - expectedConsecutive + 1) +" End number : " +i);
				break;
			}
			consecutiveNumber.clear();
		}
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
	}

	private static boolean isDivisbleByPrime(long num) {
		/*
		 * if(primes.indexOf(num)!=-1) { return false; }
		 */
		for (int i = 0; i < primes.size();) {
			if (num % primes.get(i) == 0) {
				num /= primes.get(i);
				if (consecutiveNumber.indexOf(primes.get(i)) == -1)
					consecutiveNumber.add(primes.get(i));
				i = 0;
			} else {
				i++;
			}
			if (num == 1)
				return true;
		}
		return false;
	}

	private static boolean isPrime(long n) {
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i += 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}
}
