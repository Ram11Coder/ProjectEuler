package com.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In the United Kingdom the currency is made up of pound (£) and pence (p).
 * There are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p). It is possible to make
 * £2 in the following way:
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p How many different ways can £2 be
 * made using any number of coins?
 *
 */
public class Problem31 {
	static int count = 1;
	static int coins[] = { 200, 100, 50, 20, 10, 5, 2, 1 };
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		int arr[] = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int target = 200;
		int k = 1;
		for (int i : arr) {
			for (int j = i; j <= target; j += i) {
				numberCheck(k, target - j, 1);
			}
			k++;
		}

		/*
		 * for (int ones = 1; ones <= 200; ones++) { numberCheck(1, target - ones, 1); }
		 * 
		 * for (int two = 2; two <= 200; two += 2) numberCheck(2, target - two, 1);
		 * 
		 * for (int five = 5; five <= 200; five += 5) numberCheck(3, target - five, 1);
		 * 
		 * for (int tens = 10; tens <= 200; tens += 10) numberCheck(4, target - tens,
		 * 1);
		 * 
		 * for (int twentys = 20; twentys <= 200; twentys += 20) numberCheck(5, target -
		 * twentys, 1);
		 * 
		 * for (int fiftys = 50; fiftys <= 200; fiftys += 50) numberCheck(6, target -
		 * fiftys, 1);
		 * 
		 * for (int hundred = 100; hundred <= 200; hundred += 100) numberCheck(7, target
		 * - hundred, 1);
		 */
		System.out.println("count : " + count);

	}

	private static void numberCheck(int index, int num, int in) {

		int temp = num;
		list.add(200 - num);
		for (int i = in; i < coins.length - index;) {
			if (num >= coins[i]) {
				num -= coins[i];
				list.add(coins[i]);
			} else
				i++;
			if (num == 0 || num == 1) {
				count++;
				System.out.println(list);
				list.clear();
				numberCheck(index, temp, in + 1);
				break;
			}
		}
		list.clear();
	}

}
