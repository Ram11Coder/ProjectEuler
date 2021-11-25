package com.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 *
 */
public class Problem23 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int size = 28123;
		for (int i = 1; i <= size; i++)
			if (isAbundant(i))
				list.add(i);

		boolean[] isSumof2Abundant = new boolean[size + 1];
		for (int i = 0; i < list.size(); i++)
			for (int j = i; j < list.size(); j++)
				if (list.get(i) + list.get(j) <= size)
					isSumof2Abundant[list.get(i) + list.get(j)] = true;
				else
					break;

		long sum = 0;
		for (int j = 1; j <= size; j++)
			if (!isSumof2Abundant[j])
				sum += j;

		System.out.println(sum);
	}

	// Use optimised way to find divisor sum
	private static boolean isAbundant(int n) {
		int sum = 0;
		for (int i = 1; i <= n / 2; i++)
			if (n % i == 0)
				sum += i;

		if (sum > n)
			return true;

		return false;
	}

}
