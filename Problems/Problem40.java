package com.euler;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up
 * of each of the digits 0 to 9 in some order, but it also has a rather
 * interesting sub-string divisibility property.
 * 
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note
 * the following:
 * 
 * d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible by 3 d4d5d6=635 is
 * divisible by 5 d5d6d7=357 is divisible by 7 d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13 d8d9d10=289 is divisible by 17 Find the sum of
 * all 0 to 9 pandigital numbers with this property.
 *
 */
public class Problem40 {
	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while (i < Integer.MAX_VALUE) {
			sb.append(i);
			if (sb.length() >= 1_000_000)
				break;
			i++;
		}

		/*
		 * System.out.println(sb.charAt(0) + " " + sb.charAt(9) + " " + sb.charAt(99) +
		 * " " + sb.charAt(999) + " " + sb.charAt(9_999) + " " + sb.charAt(99_999) + " "
		 * + sb.charAt(999_999));
		 */
		int arr[] = { 0, 9, 99, 999, 9999, 99999, 999999 };
		int res = 1;
		for (int j : arr)
			res *= Integer.parseInt(sb.charAt(j) + "");
		System.out.println(res);

		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
	}
}
