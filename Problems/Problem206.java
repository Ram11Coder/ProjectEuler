package com.euler;

import java.math.BigInteger;

public class Problem206 {
	private static Long[] list = new Long[] { 0L, 9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L };
	private static String number = "123456789";

	public static void main(String[] args) {
		/*
		 * BigInteger pow; loop: for (BigInteger i = BigInteger.TWO;
		 * i.compareTo(BigInteger.valueOf(10000000)) < 0; i = i .add(BigInteger.ONE)) {
		 * for (int j = 2; j <= Integer.MAX_VALUE; j++) { pow = i.pow(j); if
		 * ((String.valueOf(pow).length() == 19) && pow.mod(BigInteger.valueOf(10)) ==
		 * BigInteger.ZERO) { System.out.println(i.pow(j)); if (isConcealedSquare(pow))
		 * { System.out.println(i.pow(j)); break loop; } } else if
		 * (String.valueOf(pow).length() > 19) { break; } } }
		 */
		permutate("123546879", 0, 9);
		/*
		 * permutate("111111111", 0, 9); permutate("000000000", 0, 9);
		 * permutate("999999999", 0, 9); permutate("888888888", 0, 9);
		 * permutate("222222222", 0, 9); permutate("333333333", 0, 9);
		 * permutate("444444444", 0, 9); permutate("555555555", 0, 9);
		 * permutate("666666666", 0, 9); permutate("777777777", 0, 9);
		 * permutate("888888888", 0, 9);
		 */

	}

	private static void permutate(String str, int l, int len) {
		if (l == len) {
			if (isSquare(str)) {
				System.out.println(str);
				System.exit(0);
			}
		} else {
			for (int i = l; i < len; i++) {
				str = swap(str, l, i);
				permutate(str, l + 1, len);
				str = swap(str, l, i);
			}
		}

	}

	private static boolean isSquare(String str) {
		String newStr = "";
		for (int i = 0; i < number.length(); i++) {
			newStr += (number.charAt(i) + "" + str.charAt(i));
		}
		newStr += "0";
		BigInteger res = new BigInteger(newStr);
		BigInteger sqrt = new BigInteger(newStr).sqrt();
		if (sqrt.multiply(sqrt).compareTo(res) == 0)
			return true;

		return false;
	}

	private static String swap(String str, int l, int i) {
		char c[] = str.toCharArray();
		char t = c[l];
		c[l] = c[i];
		c[i] = t;
		return String.valueOf(c);
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
}
