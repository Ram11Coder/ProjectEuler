package com.euler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 *
 * 
 */
public class Problem24 {
	/**
	 * 1.Permutation logic 2.sort the array 3.Find out millionth position
	 * 
	 * @throws IOException
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\daily coding track\\permutation.txt"));
		long past = System.currentTimeMillis();
		String s = "0123456789";
		List<String> list = new ArrayList<String>();
		Collections.sort(permutate(s, 0, s.length(), list));
		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "Sec");
		bw.write(list + "");
		System.out.println(list.get(1_000_000 - 1));
		bw.close();
	}

	private static List<String> permutate(String str, int l, int r, List<String> list) {
		if (l == r) {
			list.add(str);
			// System.out.println(str);
		} else {
			for (int i = l; i < r; i++) {
				str = swap(str, l, i);
				list = permutate(str, l + 1, r, list);
				str = swap(str, l, i);

			}
		}

		return list;
	}

	private static String swap(String str, int l, int i) {
		char c[] = str.toCharArray();
		char temp = c[l];
		c[l] = c[i];
		c[i] = temp;
		return String.valueOf(c);
	}

}
