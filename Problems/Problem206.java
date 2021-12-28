package com.euler;

import java.math.BigInteger;

public class Problem206 {

	public static void main(String[] args) {
		BigInteger val = BigInteger.valueOf(1020304050607080900L);//min
		BigInteger maxval = BigInteger.valueOf(1929394959697989990L);//max
		BigInteger limit = val.sqrt();
		BigInteger maxlimit = maxval.sqrt();

		BigInteger pow;

		for (BigInteger i = limit; i.compareTo(maxlimit) < 0; i = i.add(BigInteger.TEN)) {

			// if ((String.valueOf(pow).length() == 19) && isConcealedSquare(pow)) {
			if (isConcealedSquare(i.pow(2))) {
				System.out.println(i);
				break;
			}

		}
	}

	// permutate("123546879", 0, 9);

	/*
	 * private static void permutate(String str, int l, int len) { if (l == len) {
	 * if (isSquare(str)) { System.out.println(str); System.exit(0); } } else { for
	 * (int i = l; i < len; i++) { str = swap(str, l, i); permutate(str, l + 1,
	 * len); str = swap(str, l, i); } }
	 * 
	 * }
	 * 
	 * private static boolean isSquare(String str) { String newStr = ""; for (int i
	 * = 0; i < number.length(); i++) { newStr += (number.charAt(i) + "" +
	 * str.charAt(i)); } newStr += "0"; BigInteger res = new BigInteger(newStr);
	 * BigInteger sqrt = new BigInteger(newStr).sqrt(); if
	 * (sqrt.multiply(sqrt).compareTo(res) == 0) return true;
	 * 
	 * return false; }
	 * 
	 * private static String swap(String str, int l, int i) { char c[] =
	 * str.toCharArray(); char t = c[l]; c[l] = c[i]; c[i] = t; return
	 * String.valueOf(c); }
	 */
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
