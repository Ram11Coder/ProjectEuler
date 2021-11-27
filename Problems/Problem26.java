package com.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Reciprocal cycles
 * 
 * Problem 26
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2 = 0.5 1/3 = 0.(3) 1/4 = 0.25 1/5 = 0.2 1/6 = 0.1(6) 1/7 = 0.(142857) 1/8
 * = 0.125 1/9 = 0.(1) 1/10 = 0.1 Where 0.1(6) means 0.166666..., and has a
 * 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring
 * cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 *
 */
public class Problem26 {
//reference : 
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 7; i < 1000; i += 2) {
			if (isprime(i))
				list.add(i);
		}

		int max = 0, index = 0;
		for (int i = 0; i < list.size(); i++) {
			int count = repeatableCount(list.get(i));
			if (max < count) {
				index = list.get(i);
				max = count;
			}
		}

		System.out.println(index + " : " + max);

	}

	private static int repeatableCount(int b) {
		int a = 1, c = 0;
		do {
			a = a * 10 % b;
			c++;
		} while (a != 1);
		return c;
	}

	private static boolean isprime(int num) {
		if (num % 2 == 0 || num % 3 == 0)
			return false;

		for (int i = 5; i * i <= num; i += 6)
			if (num % i == 0 || num % (i + 2) == 0)
				return false;
		return true;
	}

}
