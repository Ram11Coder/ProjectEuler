package com.euler;

import java.util.ArrayList;
import java.util.List;

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
public class Problem43 {
	static List<String> list = new ArrayList<String>();

	static long primes[] = { 2, 3, 5, 7, 11, 13, 17 };

	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		String num = "1234567890";
		permutate(num, 0, num.length());

		long maxSum = 0L;
		for (String s : list)
			if (checker(s))
				maxSum += Long.parseLong(s);

		System.out.println("Result : " + maxSum);
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
	}

	private static boolean checker(String s) {
		int i = 1;
		for (Long p : primes) {
			long n = Long.valueOf(s.substring(i, i + 3));
			if (!(n % p == 0))
				return false;
			i++;
		}
		return true;
	}

	private static void permutate(String num, int l, int len) {
		if (l == len) {
			list.add(num);
			// System.out.println(num);
		} else {
			for (int i = l; i < len; i++) {
				num = swap(num, i, l);
				permutate(num, l + 1, len);
				num = swap(num, i, l);
			}
		}
	}

	private static String swap(String num, int i, int l) {
		char[] arr = num.toCharArray();
		char c = arr[i];
		arr[i] = arr[l];
		arr[l] = c;
		return String.valueOf(arr);
	}
}
