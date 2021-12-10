package com.euler;
//Ref : https://projecteuler.net/problem=53

import java.math.BigInteger;

public class Problem53 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++)
			sum += million_Count(i);

		System.out.println(sum);
	}

	private static int million_Count(long n) {
		int count = 0;
		BigInteger num = BigInteger.valueOf(n);
		for (BigInteger r = BigInteger.ONE; r.compareTo(BigInteger.valueOf(n)) <= 0; r = r.add(BigInteger.ONE)) {
			BigInteger val = fact(num).divide(fact(num.subtract(r)).multiply(fact(r)));
			if (val.compareTo(BigInteger.valueOf(1_000_000)) > 0)
				count++;
		}
		return count;
	}

	public static BigInteger fact(BigInteger n) {
		if (n.compareTo(BigInteger.ZERO) == 0 || n.compareTo(BigInteger.ONE) == 0)
			return BigInteger.ONE;
		return n.multiply(fact(n.subtract(BigInteger.valueOf(1))));
	}
}
