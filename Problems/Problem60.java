package com.euler;

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

	public static void main(String[] args) {
		for (long i = 3; i <= 30000; i += 2) {
			if (isPrime(i))
				list.add(i);
		}
		// System.out.println(list);
		List<Long> val = new ArrayList<Long>();
		// Map<Long, StringBuilder> map = new HashMap<Long, StringBuilder>();
		// Map<Long, List<Long>> map = new HashMap<Long, List<Long>>();
		loop: for (int i = 0; i < list.size(); i++) {
			int count = 0;
			for (int j = i + 1; j < list.size(); j++) {
				if (concatPrime(list.get(i), list.get(j))) {
					// System.out.println(list.get(i) + " " + list.get(j));

					if (count == 0)
						val.add(list.get(i));
					count++;
					val.add(list.get(j));
				}
				if (count == 4) {
					if (check(val)) {
						System.out.println(val);
						break loop;
					} else {
						val.clear();
						count = 0;
					}
				}
			}
			// map.put(list.get(i), val);
		}

	}

	private static boolean check(List<Long> val) {
		for (int i = 0; i < val.size(); i++) {
			for (int j = i + 1; j < val.size(); j++) {
				if (!concatPrime(list.get(i), list.get(j))) {
					return false;
				}

			}
		}
		return true;
	}

	private static boolean concatPrime(long num1, long num2) {
		if (!(isPrime(Long.parseLong(num1 + "" + num2)) && isPrime(Long.parseLong(num1 + "" + num2))))
			return false;
		return true;
	}

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
