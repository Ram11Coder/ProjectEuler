package com.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Problem13 {

	public static void main(String[] args) throws IOException {
		File f = new File("D:\\daily coding track\\input.txt");

		BufferedReader br = new BufferedReader(new FileReader(f));

		long past = System.currentTimeMillis();
		String line = br.readLine();
		BigInteger sum = BigInteger.ZERO;
		while (line != null) {
			sum = sum.add(new BigInteger(line));
			line = br.readLine();
		}
		System.out.println((sum + "").subSequence(0, 10));

		System.out.println((System.currentTimeMillis() - past) / 1000.0 + "Sec");
		br.close();
	}

}
