package com.euler;

import java.math.BigInteger;

/**
 * Factorial digit sum
 * 
 * Problem 20
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * 
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 =
 * 27.
 * 
 * Find the sum of the digits in the number 100!
 *
 */
public class Problem20 {

	public static void main(String[] args) {
		factorialOfNumber(100);

	}

	private static void factorialOfNumber(int num) {
		BigInteger sum = new BigInteger("1");

		for (int fact = 2; fact <= num; fact++) {
			sum = sum.multiply(BigInteger.valueOf(fact));
		}

		String s[] = (sum + "").split("");
		int res = 0;

		for (String str : s) {
			res += Integer.parseInt(str);
		}
		System.out.println(res);
	}

}
