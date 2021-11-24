package com.euler;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem41 {
//Need to reduce the time complexity of problem for better performance
	// Time taken 2.445Sec
	public static void main(String[] args) {
		long res = 0;
		long past = System.currentTimeMillis();
		/*
		 * Choose the range (1_000_000 to 10_000_000)
		 *
		 */
		for (int i = 1_000_000; i < 10_000_000; i++)
			if ((!(i + "").contains("0")) && findPandigital(i))
				res = i;

		System.out.println(res);
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "Sec");
	}

	private static boolean findPandigital(int n) {
		if (isPrime(n) && isPandigit(n))
			return true;
		return false;
	}

	private static boolean isPandigit(int n) {
		int len = (n + "").length();
		Pattern pattern = Pattern.compile("^[1-" + len + "]+$");
		Matcher matcher = pattern.matcher(n + "");
		if (!matcher.matches())
			return false;
		int arr[] = new int[len];
		while (n > 0) {
			arr[(n % 10) - 1]++;
			n /= 10;
		}

		for (int i = 0; i < arr.length; i++)
			if (arr[i] != 1)
				return false;

		return true;
	}

	private static boolean isPrime(int n) {
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

}
