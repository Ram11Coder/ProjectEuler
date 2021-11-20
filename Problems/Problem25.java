package com.euler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 
 * 
 * 1000-digit Fibonacci number
 * 
 * Problem 25
 * 
 * The Fibonacci sequence is defined by the recurrence relation: Fn = Fn−1 +
 * Fn−2, where F1 = 1 and F2 = 1. Hence the first 12 terms will be: F1 = 1 F2 =
 * 1 F3 = 2 F4 = 3 F5 = 5 F6 = 8 F7 = 13 F8 = 21 F9 = 34 F10 = 55 F11 = 89 F12 =
 * 144 The 12th term, F12, is the first term to contain three digits. What is
 * the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 */
public class Problem25 {

	public static void main(String[] args) {
		try {
			fibonacciSeries(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void fibonacciSeries(int i) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\daily coding track\\Fibonacci.txt"));
		int count = 1;
		BigInteger a = BigInteger.valueOf(0), b = BigInteger.valueOf(1), c = BigInteger.valueOf(0);
		bw.write("Count : " + count + " num : " + b + "\n");
		while (true) {
			c = a.add(b);
			count++;
			bw.write("Count : " + count + " num : " + c	 + "\n");
			// System.out.println(c);
			if (c.toString().length() >= 1000) {
				System.out.println(c + " -> " + count);
				break;
			}
			a = b;
			b = c;
		}

	}

}
