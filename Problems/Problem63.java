package com.euler;

import java.math.BigInteger;

/**
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit
 * number, 134217728=8^9, is a ninth power.
 * 
 * How many n-digit positive integers exist which are also an nth power?
 *
 */
public class Problem63 {
	public static void main(String[] args) {
		BigInteger powVal;
		for (int i = 2; i < 10; i++) {
			for (int j =1; j <= 1000; j++) {
				powVal = BigInteger.valueOf(i).pow(j);
				BigInteger pow = powVal.mod(BigInteger.valueOf(10));
				if (pow.pow(count(powVal)).compareTo(powVal) == 0) {
					System.out.println(powVal);
				}

			}
		}
	}

	private static int count(BigInteger powVal) {

		return String.valueOf(powVal).length();
	}
}
