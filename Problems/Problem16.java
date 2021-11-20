package com.euler;

import java.math.BigInteger;

/**
 * Power digit sum
 * 
 * Problem 16
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 *
 */
public class Problem16 {

	public static void main(String[] args) {
		int sum = 0;
		BigInteger bi1 = new BigInteger("2");
		bi1 = bi1.pow(1000);
		String s[] = (bi1 + "").split("");
		System.out.println(s.length);
		for (String str : s) {
			sum += Integer.parseInt(str);
		}
		System.out.println(sum);
	}

}
