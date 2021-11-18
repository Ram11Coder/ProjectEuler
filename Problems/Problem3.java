package com.euler;

/**
 * Largest prime factor Problem 3 The prime factors of 13195 are 5, 7, 13 and
 * 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 *
 * 
 */
public class Problem3 {
	public static void main(String[] args) {
		long n = 600851475143L;
		System.out.println(findPrime(n));
	}

	private static long findPrime(long n) {

		long maxPrime = -1;

		while (n % 2 == 0) {
			System.out.print(2 + " ");
			maxPrime = 2;
			n >>= 1;
		}
		while (n % 3 == 0) {
			System.out.print(3 + " ");
			maxPrime = 3;
			n /= 3;
		}

		for (int i = 5; i < Math.sqrt(n); i += 6) {
			while (n % i == 0) {
				maxPrime = i;
				System.out.print(i + " ");
				n /= i;
			}

			while (n % (i + 2) == 0) {
				System.out.print((i + 2) + " ");
				maxPrime = i + 2;
				n /= (i + 2);
			}
		}

		if (n > 4)
			maxPrime = n;

		return maxPrime;
	}
}