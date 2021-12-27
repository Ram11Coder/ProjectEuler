package com.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem773 {

	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		List<Long> list = new ArrayList<Long>();
		list.add(2L);
		list.add(5L);
		/*
		 * list.add(7L); list.add(17L); list.add(37L);
		 */

		int n = 97;
		int start = 7;
		for (int i = 0; i < n; i++) {
			list.add((long) start);
			start = findPrimeEndsWith7(start + 1);
		}

		BigInteger bi = new BigInteger("1");
		for (Long i : list) {
			bi = bi.multiply(BigInteger.valueOf(i));
		}
		// bi = bi.mod(BigInteger.valueOf(1_000_000_007));
		System.out.println(list);
		System.out.println(bi);
		BigInteger totSum = new BigInteger("0");
		// for (BigInteger i = BigInteger.valueOf(7);
		// i.compareTo(BigInteger.valueOf(1_000_000_000)) < 0; i =
		// i.add(BigInteger.valueOf(10))) {

		for (BigInteger i = BigInteger.valueOf(7); i.compareTo(bi) <= 0; i = i.add(BigInteger.valueOf(10))) {
			if (i.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(7)))
				if (ruffNumber(i, list)) {
					System.out.println(i);
					totSum = totSum.add(i);
				}

		}

		long now = System.currentTimeMillis();

		System.out.println(totSum);

		System.out.println((now - past) / 1000);
	}

	private static boolean ruffNumber(BigInteger i, List<Long> list) {
		for (long in : list) {
			// System.out.println(i.mod(BigInteger.valueOf(in))== BigInteger.ZERO);
			if (i.mod(BigInteger.valueOf(in)) == BigInteger.ZERO) {
				return false;
			}
		}
		return true;

	}

	private static int findPrimeEndsWith7(int n) {

		for (int i = n; i < Integer.MAX_VALUE; i++)

			if (isPrime(i) && i % 10 == 7)
				return i;
		return n;

	}

	private static boolean isPrime(int i) {
		if (i <= 1)
			return false;

		if (i <= 3)
			return true;
		if (i % 2 == 0 || i % 3 == 0)
			return false;

		for (int j = 5; j * j <= i; j += 6)
			if (i % j == 0 || i % (j + 2) == 0)
				return false;
		return true;
	}
}