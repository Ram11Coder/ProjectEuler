package com.euler;

/**
 *
 * 
 * The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form 26972593−1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2p−1, have been found which contain more digits.

However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×27830457+1.

Find the last ten digits of this prime number.

 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Problem97 {
	public static void main(String[] args) /* throws IOException */ {
		long past = System.nanoTime();
		// BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\daily coding
		// track\\Large_non-Mersenne_prime.txt"));

		BigInteger two = BigInteger.TWO, bi = BigInteger.valueOf(28433);
		BigInteger res = bi.multiply(two.pow(7830457)).add(BigInteger.ONE);
		// bw.write(res + "");
		// bw.close();

		String result = String.valueOf(res);
		System.out.println(result.substring(result.length() - 10, result.length()));
		System.out.println((System.nanoTime() - past) / 1_000_000_000.0 + "sec");
	}
}
