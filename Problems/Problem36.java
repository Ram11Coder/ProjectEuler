package com.euler;

import java.math.BigInteger;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * 
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 * 
 *
 */
public class Problem36 {

	public static void main(String[] args) {
//We can use string builder also check base10
		// Need to optimize further
		long max = 0L;

		for (long i = 1; i < 1_000_000; i++)
			if (base10(i) && base2(i))
				max += i;

		System.out.println("Output -> " + max);
	}

	private static boolean base2(long num) {

		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			if (num % 2 == 0)
				sb.append("0");
			else
				sb.append("1");
			num /= 2;
		}
		long n1 = 0, n2 = 0;
		try {
			n1 = Long.parseLong(sb + "");
			n2 = Long.parseLong(sb.reverse() + "");
		} catch (Exception e) {
			BigInteger bi = new BigInteger(sb + "");
			return palindromeCheck(bi);
		}
		if (n1 == n2)
			return true;

		return false;
	}

	private static boolean palindromeCheck(BigInteger bi1) {

		BigInteger i = BigInteger.valueOf(10);
		int s = String.valueOf(bi1).length();
		BigInteger pow = BigInteger.valueOf(10);
		BigInteger r1, r2;
		pow = pow.pow(s - 1);
		while (bi1.compareTo(BigInteger.valueOf(0)) > 0) {
			r1 = bi1.mod(i);
			r2 = bi1.divide(pow);

			if (r1.compareTo(r2) != 0)
				return false;
			bi1 = bi1.mod(pow);
			bi1 = bi1.divide(i);
			pow = pow.divide(BigInteger.valueOf(100));
		}
		return true;
	}

	private static boolean base10(long num) {
		long j = String.valueOf(num).length(), r1, r2;
		j = (long) Math.pow(10, j - 1);
		while (num > 0) {
			r1 = num % 10;
			r2 = num / j;

			if (r1 != r2)
				return false;
			num = num % j;
			num /= 10;
			j /= 100;
		}
		return true;
	}

}
