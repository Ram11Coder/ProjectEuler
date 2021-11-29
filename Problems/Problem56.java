package com.euler;

import java.math.BigInteger;

public class Problem56 {
	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		long max = Long.MIN_VALUE;
		long sum = 0;
		for (int i = 99; i >= 90; i--) {
			BigInteger a = new BigInteger(i + "");

			for (int j = 99; j >= 90; j--) {
				sum = 0;
				String s[] = (a.pow(j) + "").split("");

				for (String st : s)
					sum += Integer.valueOf(st);
				if (max < sum) {
					max = sum;
					// System.out.println(i+" "+j);
				}
			}
		}
		System.out.println(max);
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
	}
}
