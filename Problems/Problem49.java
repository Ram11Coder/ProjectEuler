package com.euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
 * increases by 3330, is unusual in two ways: (i) each of the three terms are
 * prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this
 * sequence?
 *
 */
public class Problem49 {
	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> propList = new ArrayList<Integer>();// This list for caching the checked number
	static int propCount = 1;

	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		for (int i = 1001; i <= 9999; i += 2) {
			if ((!String.valueOf(i).contains("0")) && isEqualsDigit(i) && (propList.indexOf(i) == -1)) {
				permutate(String.valueOf(i), i, 0, 4);
				if (arithmeticCheck())
					propCount++;
				else if (propCount == 3)
					break;
				list.clear();
			}
		}
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
		// System.out.println(propList);
	}

	private static boolean arithmeticCheck() {
		if (list.size() > 3) {
			// Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					int diff = list.get(j) - list.get(i);
					if (diff != 0 && list.indexOf(list.get(j) + diff) != -1) {
						// System.out.println(list);
						System.out.println(
								propCount + " : " + list.get(i) + "" + list.get(j) + "" + (list.get(j) + diff));
						return true;
					}
				}
			}
		}
		return false;
	}

	private static void permutate(String n, int num, int i, int len) {
		if (i == len - 1 && isPrime(Integer.valueOf(n))) {
			list.add(Integer.valueOf(n));
			if (propList.indexOf(Integer.valueOf(n)) == -1)
				propList.add(Integer.valueOf(n));
		} else {
			for (int j = i; j < len; j++) {
				n = swap(n, j, i);
				permutate(n, num, i + 1, len);
				n = swap(n, j, i);
			}
		}
	}

	private static boolean isPrime(int n) {

		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		return true;
	}

	private static String swap(String n, int j, int i) {
		char c[] = n.toCharArray();
		char t = c[j];
		c[j] = c[i];
		c[i] = t;
		return String.valueOf(c);
	}

	private static boolean isEqualsDigit(int num) {
		int hash[] = new int[10];
		int temp = num;
		while (num > 0) {
			hash[num % 10]++;
			num /= 10;
		}

		while (temp > 0) {
			if (hash[temp % 10] >= 3)
				return false;
			temp /= 10;
		}
		return true;
	}

}
