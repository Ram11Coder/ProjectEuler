package com.euler;
/**
 * It is possible to write five as a sum in exactly six different ways:

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

How many different ways can one hundred be written as a sum of at least two positive integers?

 *
 */
public class Problem76 {
	static int c;

	public static void main(String[] args) {
		long past = System.currentTimeMillis();
		int n = 100;
		int arr[] = new int[n];
		summationCount(n, arr, 0, 0);
		System.out.println(c-1);//Exculde 100 as a count
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "sec");
	}

	private static void summationCount(int n, int[] arr, int curr_sum, int curr_index) {
		if (n == curr_sum) {
			c++;
		} else {
			int num = 1;
			while (num <= n - curr_sum && (curr_index == 0 || num <= arr[curr_index - 1])) {
				arr[curr_index] = num;
				summationCount(n, arr, curr_sum + num, curr_index + 1);
				num++;
			}
		}
	}
}
