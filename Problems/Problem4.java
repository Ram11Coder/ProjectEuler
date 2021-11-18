package com.euler;

/**
 * Largest palindrome
 * 
 * product Problem 4
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 */
public class Problem4 {
	public static void main(String[] args) {
		long maxPalindrome = Long.MIN_VALUE;
		for (long i = 999; i >= 100; i--)
			for (int j = 999; j >= 100; j--)
				if (palindromeCheck(i * j) && (maxPalindrome < (i * j))) {
					maxPalindrome = (i * j);
					break;
				}

		System.out.println(maxPalindrome);
	}

	private static boolean palindromeCheck(long num) {
		StringBuilder sb = new StringBuilder(num + "");
		sb = sb.reverse();
		if (sb.toString().equals(num + ""))
			return true;
		return false;
	}
}
