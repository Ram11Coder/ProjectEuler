package com.euler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Consecutive prime sum
 * 
 * The prime 41, can be written as the sum of six consecutive primes:
 * 
 * 41 = 2 + 3 + 5 + 7 + 11 + 13 This is the longest sum of consecutive primes
 * that adds to a prime below one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 *
 */
public class Problem50 {

	public static void main(String[] args) throws IOException {
		long past = System.currentTimeMillis();
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		for (int i = 3; i < 1_000_000; i += 2)
			if (isPrime(i))
				list.add(i);

		int max_Count = 0, max_value = 0;
		int n = list.indexOf(1009);
		for (int i = n; i < list.size(); i++) {
			int cons_count = consecutiveMethod(list, list.get(i));
			if (max_Count < cons_count) {
				max_Count = cons_count;
				max_value = list.get(i);
			}
		}
		System.out.println(max_value + " : " + max_Count);
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
	}

	private static int consecutiveMethod(List<Integer> list, int num) {
		int temp = num;
		int index = list.indexOf(num) - 1;
		for (int i = 0; i < index/2; i++) {
			int count = 0, sum = 0;
			for (int j = i; j <= index; j++) {
				sum = sum + list.get(j);
				count++;
				if (temp == sum)
					return count;
				if (sum > temp)
					break;
			}
		}
		return -1;
	}

	private static boolean isPrime(int n) {
		if (n <= 3) {
			return true;
		}
		if (n % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}

}
