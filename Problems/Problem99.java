package com.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Comparing two numbers written in index form like 211 and 37 is not difficult,
 * as any calculator would confirm that 211 = 2048 < 37 = 2187.
 * 
 * However, confirming that 632382518061 > 519432525806 would be much more
 * difficult, as both numbers contain over three million digits.
 * 
 * Using base_exp.txt (right click and 'Save Link/Target As...'), a 22K text
 * file containing one thousand lines with a base/exponent pair on each line,
 * determine which line number has the greatest numerical value.
 * 
 * NOTE: The first two lines in the file represent the numbers in the example
 * given above.
 *
 */
public class Problem99 {
	public static void main(String[] args) throws IOException {

		double base, max = 0, val;
		long value;
		BufferedReader br = new BufferedReader(new FileReader("D:\\daily coding track\\p099_base_exp.txt"));
		String line = br.readLine();
		int lineNumer = 0, trackLine = 0;

		while (line != null) {
			lineNumer++;
			String str[] = line.split(",");
			base = Math.log10(Integer.valueOf(str[0]));
			value = Integer.valueOf(str[1]);
			val = base * value;
			if (val > max) {
				max = val;
				trackLine = lineNumer;
			}
			line = br.readLine();
		}
		System.out.println(trackLine);
		br.close();
	}
}
