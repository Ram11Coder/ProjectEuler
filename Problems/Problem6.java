package com.euler;

/**
 * Sum square difference Problem 6 The sum of the squares of the first ten
 * natural numbers is, The square of the sum of the first ten natural numbers
 * is, Hence the difference between the sum of the squares of the first ten
 * natural numbers and the square of the sum is . Find the difference between
 * the sum of the squares of the first one hundred natural numbers and the
 * square of the sum.
 *
 */
public class Problem6 {
	public static void main(String[] args) {

		System.out.println(sumOf100NumbersSquare(100) - sumOfSquareOfEachNumbers100(100));
	}

	private static long sumOf100NumbersSquare(int n) {
		long sum = 1;
		for (long i = 2; i <= n; i++) {
			sum += i;
		}
		sum *= sum;
		System.out.println(sum);
		return sum;
	}

	private static long sumOfSquareOfEachNumbers100(long n) {
		long sum = 1;
		for (long i = 2; i <= n; i++) {
			sum += (i * i);
		}
		System.out.println(sum);
		return sum;
	}
}
