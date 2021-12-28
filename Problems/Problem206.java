package com.euler;

import java.math.BigInteger;

public class Problem206 {
	static int possibillity = 0;
	static long[] list = { 0L, 9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L };
	static long past = System.currentTimeMillis();

	public static void main(String[] args) {

		// bruteForce();
		myOwnApproach();
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + " sec");
		// System.out.println(possibillity);
	}

	private static void myOwnApproach() {

		permutate("", 1, 18);

	}

	/**
	 * Bruteforce 13.769 sec
	 *
	 */
	private static void bruteForce() {
		BigInteger val = BigInteger.valueOf(1020304050607080900L);// min
		BigInteger maxval = BigInteger.valueOf(1929394959697989990L);// max
		BigInteger limit = val.sqrt(), maxlimit = maxval.sqrt();

		for (BigInteger i = limit; i.compareTo(maxlimit) < 0; i = i.add(BigInteger.TEN)) {

			// if ((String.valueOf(pow).length() == 19) && isConcealedSquare(pow)) {
			if (isConcealedSquare(i.pow(2))) {
				System.out.println(i);
				break;
			}

		}
	}

	private static boolean isConcealedSquare(BigInteger num) {
		int i = 0;
		while ((num.compareTo(BigInteger.valueOf(0L))) > 0) {
			BigInteger rem = num.mod(BigInteger.valueOf(10));
			if (rem.compareTo(BigInteger.valueOf(list[i])) == 0)
				i++;
			else
				return false;
			num = num.divide(BigInteger.valueOf(100));
		}
		return true;
	}

	/**
	 * 2nd approach(Recursive ) -> Total 10^9 possibilities
	 * 
	 * If we iterate the possibility from 9 to 0 in loop 1.582 sec and 2_757_520th
	 * possibility
	 * 
	 * If we iterate the possibility from 0 to 9 in loop 623.035 sec and got the o/p
	 * in 997242481th possibility
	 */
	private static void permutate(String str, int l, int len) {
		if (str.length() == len && l == 10) {
			str += "0";
			// possibillity++;

			if (isSquare(str)) {
				System.out.println(str);
				System.out.println((System.currentTimeMillis() - past) / 1000.0 + " sec");
				System.out.println(possibillity);
				System.exit(0);
			}

		} else {
			str += l;
			for (int i = 9; i >= 0; i--) {
				str += i;
				permutate(str, l + 1, len);
				str = str.substring(0, str.length() - 1);
			}
		}

	}

	private static boolean isSquare(String str) {
		BigInteger res = new BigInteger(str);
		BigInteger sqrt = res.sqrt();
		if (sqrt.multiply(sqrt).compareTo(res) == 0)
			return true;
		return false;
	}

}
