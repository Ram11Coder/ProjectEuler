package com.euler;

import java.util.ArrayList;
import java.util.List;

//https://projecteuler.net/problem=27
public class Problem27 {
	static int max = Integer.MIN_VALUE, indexA, indexB;
	static List<Integer> list = new ArrayList<Integer>();
//We can binary search instead indexOf() and check time complexity
	
	static {
		for (int i = 1; i < 1000; i += 2) {
			if (isPrime(i))
				list.add(i);
		}
	}

	public static void main(String[] args) {
		long past = System.currentTimeMillis();

		for (int i = -999; i < 1000; i++)
			for (int j = -1000; j <= 1000; j++)
				primeCheck(i, j);
		System.out.println(indexA * indexB);
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
		/*
		 * past = System.currentTimeMillis(); for (int i = -999; i < 1000; i++) for (int
		 * j = -1000; j <= 1000; j++) anotehrApproach(i, j);
		 * 
		 * System.out.println(indexA * indexB);
		 * System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
		 */

		

	}

	private static void anotehrApproach(int a, int b) {
		int n = 0, count = 0;
		while (list.indexOf((n * n) + (a * n) + b) != -1) {
			count++;
			n++;
		}
		if (max < count) {
			max = count;
			indexA = a;
			indexB = b;
		}
	}

	private static void primeCheck(int a, int b) {
		int n = 0, count = 0;
		while (isPrime((n * n) + (a * n) + b)) {
			count++;
			n++;
		}
		if (max < count) {
			max = count;
			indexA = a;
			indexB = b;
		}
	}

	private static boolean isPrime(long n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6)
			if (n % i == 0 || (n % (i + 2) == 0))
				return false;

		return true;
	}
}
