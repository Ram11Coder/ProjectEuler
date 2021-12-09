package com.euler;

import java.math.BigInteger;

/**
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician
 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which
 * is correct, is obtained by cancelling the 9s.
 * 
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * 
 * There are exactly four non-trivial examples of this type of fraction, less
 * than one in value, and containing two digits in the numerator and
 * denominator.
 * 
 * If the product of these four fractions is given in its lowest common terms,
 * find the value of the denominator.
 *
 */
public class Problem33 {
//Need to opimise further
	public static void main(String[] args) {
		int numerator = 1, denom = 1;
		for (int i = 10; i <= 99; i++) {
			for (int j = 10; j < i; j++) {
				if (((!String.valueOf(i).contains("0")) && (!String.valueOf(j).contains("0"))) && digit_Contains(i, j)
						&& bad_fractionCheck(i, j)) {
					// System.out.println(i + "/" + j);
					// Reason why num mul by j and denom mul is
					// num/denom <1
					numerator *= j;
					denom *= i;
				}
			}
		}
		// System.out.println(numerator + " " + denom);
		BigInteger a = BigInteger.valueOf(numerator);
		BigInteger b = BigInteger.valueOf(denom);

		System.out.println(b.divide(a.gcd(b)));
	}

	private static boolean bad_fractionCheck(int num, int denom) {
		double before = (double) num / denom;
		int pow = 10;
		int num1 = num / pow;
		int num2 = num % pow;

		int denom1 = denom / pow;
		int denom2 = denom % pow;
		int finalNum = 0, finalDenom = 0;

		if (num1 == denom1) {
			finalNum = num2;
			finalDenom = denom2;
		} else if (num1 == denom2) {
			finalNum = num2;
			finalDenom = denom1;
		} else if (num2 == denom1) {
			finalNum = num1;
			finalDenom = denom2;
		} else if (num2 == denom2) {
			finalNum = num1;
			finalDenom = denom1;
		}
		double after = (double) finalNum / finalDenom;
		if (before == after) {
			return true;
		}
		return false;
	}

	private static boolean digit_Contains(int n, int d) {
		while (n > 0) {
			int r = n % 10;
			if (String.valueOf(d).contains(r + ""))
				return true;
			n /= 10;
		}
		return false;
	}
}
