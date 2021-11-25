package com.euler;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Digit factorials
 * 
 * Problem 34
 * 
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.
 * 
 * Note: As 1! = 1 and 2! = 2 are not sums they are not included.
 *
 */
public class Problem34 {

	public static void main(String[] args) throws IOException {
		
		long sum=0;
		for (long i = 3; i < 2000000; i++) {
			if (findFactSum(i)) {
				sum+=i;
				System.out.println(i);
			}
			
		}
		System.out.println(sum);
	}

	private static boolean findFactSum(long num) {
		long temp = num;
		BigInteger sum = BigInteger.ZERO;
		while (num > 0) {
			sum = sum.add(BigInteger.valueOf(fact(num % 10)));
			num /= 10;
		}
		return temp == sum.longValue();

	}

	private static long fact(long uptoValue) {
		BigInteger answer = BigInteger.ONE;
		boolean oddUptoValue = ((uptoValue & 1) == 1);
		long tempUptoValue = uptoValue;
		if (oddUptoValue) {
			tempUptoValue = uptoValue - 1;
		}

		long nextSum = tempUptoValue;
		long nextMulti = tempUptoValue;
		while (nextSum >= 2) {
			answer = answer.multiply(BigInteger.valueOf(nextMulti));
			nextSum -= 2;
			nextMulti += nextSum;
			// long product=(tempUptoValue-i+1L)*i;

		}
		if (oddUptoValue) {
			answer = answer.multiply(BigInteger.valueOf(uptoValue));
		}
		//System.out.println(answer);

		return answer.longValue();
	}

}
