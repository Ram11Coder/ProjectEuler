package com.euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
 * so the first ten triangle numbers are:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * By converting each letter in a word to a number corresponding to its
 * alphabetical position and adding these values we form a word value. For
 * example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value
 * is a triangle number then we shall call the word a triangle word.
 * 
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
 * containing nearly two-thousand common English words, how many are triangle
 * words?
 *
 */
public class Problem42 {

	public static void main(String[] args) {

		List<Integer> triNum = new ArrayList<Integer>();
		for (int n = 1; n < 100; n++)
			triNum.add((n * (n + 1)) / 2);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\daily coding track\\p042_words.txt"));
			int count = 0;
			String line = br.readLine();
			while (line != null) {
				String words[] = line.split(",");

				for (String s : words) {
					int sum = 0;
					for (char c : s.toCharArray())
						sum += (int) (c - 'A') + 1;

					if (triNum.indexOf(sum) != -1)
						count++;
				}

				line = br.readLine();
			}
			System.out.println("Count -> " + count);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
