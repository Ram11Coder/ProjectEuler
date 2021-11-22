package com.euler;

/**
 * Circular primes
 * 
 * Problem 35
 * 
 * The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
 * 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 *
 * 
 */
public class Problem35 {
	public static void main(String[] args) {
		int totCount = 1;
		for (long i = 3; i < 1_000_000; i += 2) {
			String s = i + "";
			if (isPrime(i) && (!s.contains("0")) && isRotate(i))
				totCount++;
			// System.out.println(i);

		}
		System.out.println(totCount);
	}

	private static boolean isRotate(long num) {

		int len = (num + "").length();
		if (len == 1)
			return true;

		if (len == 2) {
			long n = ((num % 10) * 10) + (num / 10);
			return isPrime(n);
		}

		for (int i = 0; i < len - 1; i++) {
			num = nextRotateElements(num, len);
			if (!isPrime(num))
				return false;
		}

		return true;
	}

	private static long nextRotateElements(long num, long len) {
		long div = (long) Math.pow(10, len - 1);
		long rem = (num % div) * 10 + (num / div);
		return rem;
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
