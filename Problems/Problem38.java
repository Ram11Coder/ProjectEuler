package com.euler;

import java.math.BigInteger;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * 
 * 192 × 1 = 192 192 × 2 = 384 192 × 3 = 576 By concatenating each product we
 * get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated
 * product of 192 and (1,2,3)
 * 
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,
 * and 5, giving the pandigital, 918273645, which is the concatenated product of
 * 9 and (1,2,3,4,5).
 * 
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as
 * the concatenated product of an integer with (1,2, ... , n) where n > 1?
 *
 */
public class Problem38 {
	static long max = Long.MIN_VALUE;

	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		for (int i = 1; i < 10000; i++) {
			if (String.valueOf(i).length() == 1)
				pandigitalCheck(i, 1, 2, 3, 4, 5);
			else if (String.valueOf(i).length() == 2)
				pandigitalCheck(i, 1, 2, 3, 4);
			else if (String.valueOf(i).length() == 3)
				pandigitalCheck(i, 1, 2, 3);
			if (String.valueOf(i).length() == 4)
				pandigitalCheck(i, 1, 2);
		}

		System.out.println(max);
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
	}

	private static void pandigitalCheck(int num, int... arr) {
		String s = "";
		for (int i : arr)
			s += (num * i);

		if (s.length() == 9 && isPandigital(s) && max < Long.parseLong(s))
			max = Long.parseLong(s);
	}

	private static boolean isPandigital(String num) {
		int hash[] = new int[10];
		for (int i = 0; i < num.length(); i++)
			hash[Integer.parseInt(num.charAt(i) + "")]++;

		for (int i = 1; i < hash.length; i++)
			if (hash[i] != 1)
				return false;

		return true;
	}
}
