package com.euler;

/**
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Problem37 {
	public static void main(String[] args) {
		int count = 0;
		long sum = 0;
		for (int i = 23; count < 11; i += 2) {
			if (isPrime(i) && rightRotate(i) && leftRotate(i)) {
				count++;
				sum += i;
			}
		}
		System.out.println(sum);
	}

	private static boolean isPrime(int n) {

		if (n <= 1) {
			return false;
		}

		if (n <= 3) {
			return true;
		}
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i += 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		return true;
	}

	private static boolean leftRotate(int num) {
		int len = (num + "").length();
		for (int i = 0; i < len - 1; i++) {
			num = num % (int) Math.pow(10, len - i - 1);
			if (!isPrime(num))
				return false;
		}
		return true;
	}

	private static boolean rightRotate(int num) {
		int len = (num + "").length() - 1;

		while (len > 0) {
			if (!isPrime(num / 10))
				return false;
			len--;
			num = num / 10;
		}
		return true;
	}
}
