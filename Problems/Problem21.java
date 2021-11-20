package com.euler;

/**
 * Amicable numbers
 * 
 * Problem 21
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 *
 *
 *
 */
public class Problem21 {

	public static void main(String[] args) {
		totalAmicableNumberUnder10000(10000);

	}

	private static void totalAmicableNumberUnder10000(int num) {

		for (int j = 4; j < num; j++) {
			int num1 = amicableDivisor(j);

			if (amicableDivisor(num1) == j) {
				System.out.println(j);
			}
		}

	}

	private static int amicableDivisor(int div) {
		int divisorSum = 0;
		for (int i = 1; i <= div / 2; i++) {
			if (div % i == 0) {
				divisorSum += i;
			}
		}
		return divisorSum;
	}

}
