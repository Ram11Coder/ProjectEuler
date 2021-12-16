package com.euler;

/**
 * 
 * It was proposed by Christian Goldbach that every odd composite number can be
 * written as the sum of a prime and twice a square.
 * 
 * 9 = 7 + 2×12 15 = 7 + 2×22 21 = 3 + 2×32 25 = 7 + 2×32 27 = 19 + 2×22 33 = 31
 * + 2×12
 * 
 * It turns out that the conjecture was false.
 * 
 * What is the smallest odd composite that cannot be written as the sum of a
 * prime and twice a square?
 *
 */
public class Problem46 {
	public static void main(String[] args) {
		for (long i = 9; i <= 100_00; i += 2)
			if (smallestOddComposite(i)) {
				System.out.println(i);
				break;
			}
	}

	private static boolean smallestOddComposite(long n) {
		long num = n;
		long i = 1, mul = 0;
		while (num > mul) {
			if (isPrime(num - mul))
				return false;
			mul = 2 * ((int) Math.pow(i++, 2));
		}
		return true;
	}

	private static boolean isPrime(long n) {
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (long i = 5; i * i <= n; i += 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

}
