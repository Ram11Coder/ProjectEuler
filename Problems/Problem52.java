package com.euler;

/**
 * It can be seen that the number, 125874, and its double, 251748, contain
 * exactly the same digits, but in a different order.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
 * contain the same digits.
 *
 * 
 */
public class Problem52 {
	public static void main(String[] args) {

		for (int i = 12; i < Integer.MAX_VALUE; i++)
			if (isMultipleSame(i)) {
				System.out.println(i);
				break;
			}
	}

	private static boolean isMultipleSame(int n) {
		if (isMultiple2(2 * n, n) && isMultiple2(3 * n, n) && isMultiple2(4 * n, n) && isMultiple2(5 * n, n)
				&& isMultiple2(6 * n, n))
			return true;
		return false;
	}

	private static boolean isMultiple2(int num, int res) {
		String s = num + "";

		for (int i = 0; i < s.length() - 1; i++) {
			s = s.substring(1) + s.substring(0, 1);
			if (Integer.parseInt(s) == res)
				return true;
		}
		return false;
	}
}
