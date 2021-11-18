package com.euler;

/**
 * 
 * Special Pythagorean triplet
 * 
 * Problem 9
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which,
 * 
 * a2 + b2 = c2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 *
 */
public class Problem9 {

	public static void main(String[] args) {
//long i=33,j=34,k=35;

		loop: for (int i = 1; i < 1000; i++) {
			for (int j = i + 1; j < 1000; j++) {
				for (int k = j + 1; k < 1000; k++) {
					if (isPythagores(i, j, k) && (i + j + k) == 1000) {
						System.out.println(("i ->" + i + " j-> " + j + " k-> " + k) + " " + (i * j * k));
						break loop;
					}
				}
			}
		}
	}

	private static boolean isPythagores(int i, int j, int k) {
		if ((i * i) + (j * j) == (k * k))
			return true;

		return false;
	}

}
