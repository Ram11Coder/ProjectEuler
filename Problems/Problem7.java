package com.euler;

/**
 * 10001st prime Problem 7 By listing the first six prime numbers: 2, 3, 5, 7,
 * 11, and 13, we can see that the 6th prime is 13. What is the 10 001st prime
 * number?
 *
 */
public class Problem7 {

	public static void main(String[] args) {
		int count = 0;

		for (long i = 2; i <= Long.MAX_VALUE; i++) {

			if (isPrime(i))
				count++;
			if (count == 10001) {
				System.out.println("Final o/p-> " + i);
				break;
			}
		}
	}

	private static boolean isPrime(long n) {
		if (n <= 1)
			return false;

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
