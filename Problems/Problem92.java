package com.euler;

/**
 * Square digit chains
 * 
 * A number chain is created by continuously adding the square of the digits in
 * a number to form a new number until it has been seen before.
 * 
 * For example,
 * 
 * 44 → 32 → 13 → 10 → 1 → 1
 * 
 * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
 * 
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless
 * loop. What is most amazing is that EVERY starting number will eventually
 * arrive at 1 or 89.
 * 
 * How many starting numbers below ten million will arrive at 89?
 *
 */
public class Problem92 {
	public static void main(String[] args) {
		long count = 0;
		for (long i = 2; i < 10_000_000; i++)
			if (isSquareDigitChain(i))
				count++;

		System.out.println(count);
	}

	private static boolean isSquareDigitChain(long num) {
		while (num != 89) {
			num = squareCheck(num);
			if (num == 1)
				return false;
		}
		return true;
	}

	private static long squareCheck(long num) {
		long res = 0;
		while (num > 0) {
			res += Math.pow(num % 10, 2);
			num /= 10;
		}
		return res;
	}
}
