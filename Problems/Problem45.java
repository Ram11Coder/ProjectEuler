package com.euler;

/**
 * Triangle, pentagonal, and hexagonal numbers are generated by the following
 * formulae:
 * 
 * Triangle Tn=n(n+1)/2 1, 3, 6, 10, 15, ... Pentagonal Pn=n(3n−1)/2 1, 5, 12,
 * 22, 35, ... Hexagonal Hn=n(2n−1) 1, 6, 15, 28, 45, ... It can be verified
 * that T285 = P165 = H143 = 40755.
 * 
 * Find the next triangle number that is also pentagonal and hexagonal
 *
 */
public class Problem45 {
	static long i = 2, j = 2, k = 2;

	public static void main(String[] args) {
		int count = 0;
		for (; i < 100000; i++) {
			if (pentagonal(triangle(i)) && hexagonal(triangle(i))) {
				count++;
			}
			if (count == 2) {
				System.out.println(i + " " + j + " " + k);
				System.out.println("Triangle (" + i + ") " + triangle(i) + " pentagonal (" + k + ") "
						+ ((k * (3 * k - 1)) / 2) + " hex (" + j + ") " + (j * (2 * j - 1)));
				break;
			}
		}
	}

	private static boolean pentagonal(long t) {
		long pen = (k * (3 * k - 1)) / 2;
		while (pen < t) {
			k++;
			pen = (k * (3 * k - 1)) / 2;
		}
		if (pen == t)
			return true;
		return false;
	}

	private static boolean hexagonal(long t) {
		long hex = j * (2 * j - 1);
		while (hex < t) {
			j++;
			hex = j * (2 * j - 1);
		}
		if (hex == t)
			return true;
		return false;
	}

	private static long triangle(long n) {
		return (n * (n + 1)) / 2;
	}
}