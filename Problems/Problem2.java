package com.euler;

/**
 * Even Fibonacci numbers Submit
 * 
 * Problem 2 Each new term in the Fibonacci sequence is generated by adding the
 * previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * 
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not exceed
 * four million, find the sum of the even-valued terms.
 */
public class Problem2 {
	public static void main(String[] args) {

		int a = 0, b = 1, c = a + b, sum = 0;
		while (c < 4_000_000) {
			if (c % 2 == 0)
				sum += c;
			a = b;
			b = c;
			c = a + b;
		}
		System.out.println(sum);
	}
}
