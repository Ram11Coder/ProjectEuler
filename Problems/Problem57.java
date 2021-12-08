package com.euler;

import java.math.BigInteger;

//https://projecteuler.net/problem=57

public class Problem57 {
	static int count = 0;
	static int propCount = 0;

	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		BigInteger i = BigInteger.valueOf(1);
		div(i, "1/2", count);
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
	}

	private static void div(BigInteger i, String s, long c) {
		if (c == 1000) {
			System.out.println(propCount);
			return;
		}
		String div[] = s.split("/");
		BigInteger num = new BigInteger(div[0]);
		BigInteger denom = new BigInteger(div[1]);
		BigInteger numerator = denom.multiply(BigInteger.valueOf(2)).add(num);// 12
		BigInteger temp = numerator;
		numerator = denom;
		denom = temp;
		BigInteger temp_Num = numerator, temp_Denom = denom;
		numerator = denom.multiply(i).add(numerator);
		if (String.valueOf(numerator).length() > String.valueOf(denom).length())
			propCount++;

		// System.out.println(numerator + "/" + denom);
		div(i, temp_Num + "/" + temp_Denom, c + 1);
	}

}
