package com.euler;

/**
 * Digit fifth powers
 * 
 * Problem 30
 * 
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:
 * 
 * 1634 = 14 + 64 + 34 + 44 8208 = 84 + 24 + 04 + 84 9474 = 94 + 44 + 74 + 44 As
 * 1 = 14 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 *
 * 
 */
public class Problem30 {

	public static void main(String[] args) {

		System.out.println(sumOfFifthPower());
	}

	/**
	 * We need to find a number x95 which gives us an x digit number. We can do this
	 * by hand. Since 9^5 = 59049, we need at least 5 digits. 59^5 = 295245, so with 5
	 * digits we can make a 6 digit number. 6*95 = 354294. So 355000 seems like a
	 * reasonable upper bound to use
	 */

	private static int sumOfFifthPower() {
		int max = 0;
		for (int i = 2; i < 355000; i++) 
			if (powerOfNum(i)) 
				max += i;
		return max;
	}

	private static boolean powerOfNum(int num) {
		int sum = 0;
		String s[] = (num + "").split("");
		for (String str : s) 
			sum += (Math.pow(Integer.parseInt(str), 5));
		
		if (num == sum) 
			return true;
		
		return false;
	}

}
