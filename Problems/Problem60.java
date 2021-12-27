package com.euler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes
 * and concatenating them in any order the result will always be prime. For
 * example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these
 * four primes, 792, represents the lowest sum for a set of four primes with
 * this property.
 * 
 * Find the lowest sum for a set of five primes for which any two primes
 * concatenate to produce another prime.
 *
 */
public class Problem60 {
	static List<Long> list = new ArrayList<Long>();
	static List<Long> finallist = new ArrayList<Long>();

	public static void main(String[] args) throws IOException {
		for (long i = 3; i <= 30_000; i += 2)
			if (isPrime(i))
				list.add(i);

		System.out.println(list.get(list.size() - 1));
		/*
		 * BufferedWriter bw = new BufferedWriter(new
		 * FileWriter("D:\\daily coding track\\prime_list_new.txt")); bw.write(list +
		 * "");
		 */

		System.out.println(list.size());
		loop: for (int i = 1500; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (isPrime(Long.valueOf(list.get(i) + "" + list.get(j)))
						&& isPrime(Long.valueOf(list.get(j) + "" + list.get(i)))) {
					if (finallist.size() == 0) {
						finallist.add(list.get(i));
						finallist.add(list.get(j));
					}

					if (finallist.size() > 1 && finalListCheck(list.get(j))) {
						finallist.add(list.get(j));
					}
				}
				if (finallist.size() >= 5) {
					System.out.println(finallist);
					break loop;
				}
				// System.out.println(j + " : " + list.get(j));
			}
			System.out.println(finallist);
			finallist.clear();
		}
		System.out.println(finallist);

	}

	private static boolean finalListCheck(long j) {
		for (Long l : finallist)
			if (!(isPrime(Long.valueOf(l + "" + j)) && isPrime(Long.valueOf(j + "" + l))))
				return false;

		return true;
	}

	/*
	 * private static boolean check(List<Long> val) { for (int i = 0; i <
	 * val.size(); i++) { for (int j = i + 1; j < val.size(); j++) { if
	 * (!concatPrime(list.get(i), list.get(j))) { return false; }
	 * 
	 * } } return true; }
	 * 
	 * private static boolean concatPrime(long num1, long num2) { if
	 * (!(isPrime(Long.parseLong(num1 + "" + num2)) && isPrime(Long.parseLong(num1 +
	 * "" + num2)))) return false; return true; }
	 */
	private static boolean isPrime(long i) {
		if (i <= 1) {
			return false;
		}
		if (i <= 3)
			return true;
		if (i % 2 == 0 || i % 3 == 0)
			return false;
		for (int j = 5; j * j <= i; j += 6) {
			if (i % j == 0 || i % (j + 2) == 0)
				return false;
		}
		return true;
	}

}
