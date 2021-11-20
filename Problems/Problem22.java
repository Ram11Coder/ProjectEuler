package com.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * Names scores
 * 
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 *
 */
public class Problem22 {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\daily coding track\\p022_names.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		/*
		 * String line = br.readLine(); String s[] = line.split(",");
		 * System.out.println(s.length); Arrays.sort(s); for (String str : s) {
		 * System.out.println(str); }
		 */

		String line = br.readLine();
		// BigInteger sum = new BigInteger("0");

		long Toatalsum = 0;
		while (line != null) {
			String s[] = line.split(",");
			Arrays.sort(s);
			System.out.println(s.length);
			for (int k = 0; k < s.length; k++) {
				String word = s[k];
				int sum = 0;
				for (int i = 0; i < word.length(); i++) {
					// sum = sum.add(BigInteger.valueOf((long) (word.charAt(i) - 'A') + 1));
					sum = sum + ((word.charAt(i) - 'A') + 1);
				}
				// sum = sum.multiply(BigInteger.valueOf(k));
				Toatalsum += sum * (k + 1);
				System.out.println(word + " " + (k + 1) + " " + Toatalsum);
				// System.out.println(word + " " + sum + " " + k);
			}
			line = br.readLine();
		}

	}
}
