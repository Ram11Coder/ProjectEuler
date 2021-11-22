package com.euler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Pandigital products
 * 
 * Problem 32
 * 
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1
 * through 5 pandigital.
 * 
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
 * multiplicand, multiplier, and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 * 
 * HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 */
public class Problem32 {
	public static void main(String[] args) throws IOException {
		long multipicand = 10000, multiplier = 100, product;
		long past = System.currentTimeMillis();
		Set<Long> resultSet = new HashSet<Long>();
		for (int i = 2; i < multipicand; i++) {
			String c = i + "";
			if (c.contains("0") || c.length() != c.chars().distinct().count())
				continue;

			for (int j = 1; j < multiplier; j++) {
				if (j % 10 == 0)
					continue;
				product = i * j;
				String s = i + "" + j + "" + product;

				if (s.length() == 9 && checkDigits(s))
					resultSet.add(product);
			}

		}
		long finalRes = 0;
		for (Long l : resultSet) {
			finalRes += l;
		}
		System.out.println(finalRes);
		System.out.println(((System.currentTimeMillis() - past) / 1000.0) + " sec");
	}

	private static boolean checkDigits(String s) {

		int hash[] = new int[10];
		String num[] = s.split("");
		for (String st : num)
			hash[Integer.parseInt(st)]++;

		for (int i = 1; i < hash.length; i++)
			if (hash[i] != 1)
				return false;

		return true;
	}
}
