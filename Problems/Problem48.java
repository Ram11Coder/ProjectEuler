package com.euler;

import java.math.BigInteger;

/**
 * Self powers
 * 
 * Prolem 48
 * 
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * 
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Problem48 {
	public static void main(String[] args) {
		BigInteger bi = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {
			bi = bi.add(BigInteger.valueOf(i).pow(i));
		}

		String res = (bi + "");
		System.out.println(res.substring(res.length() - 10, res.length()));
	}
}
