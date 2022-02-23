package com.euler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem684 {
	static final int LIMIT = 90;
	static final BigInteger NINE = BigInteger.valueOf(9);
	static BigInteger fibArr[] = new BigInteger[LIMIT + 1];
	static Map<BigInteger, BigInteger> map = new HashMap<BigInteger, BigInteger>();

	private static void initFib() {

		fibArr[0] = BigInteger.ZERO;
		fibArr[1] = BigInteger.ONE;
		for (int i = 2; i < fibArr.length; i++) {
			fibArr[i] = fibArr[i - 1].add(fibArr[i - 2]);
		}
	}

	public static void main(String[] args) {
		// System.out.println(fibonacciNo(90));
		// System.out.println(Long.MAX_VALUE);
		initFib();
		BigInteger Totalsum = BigInteger.ZERO;
		for (int i = 2; i < fibArr.length; i++) {
			/* System.out.println(fibArr[i]); */
			Totalsum = Totalsum.add(caldigitSum(fibArr[i]));
		}
		System.out.println(Totalsum.mod(BigInteger.valueOf(1_000_000_007)));
		System.out.println(fibArr[90].divide(NINE));
		// inverseDigitSum(50);
		// System.out.println(caldigitSum(10000));
	}

//Implement Biginteger here

	private static void inverseDigitSum(int limit) {
		BigInteger Totalsum = BigInteger.ZERO;
		for (int i = 2; i <= limit; i++) {
			Totalsum = Totalsum.add(caldigitSum(fibArr[i]));
		}
		System.out.println(Totalsum.mod(BigInteger.valueOf(1_000_000_007)));
	}

	public static BigInteger caldigitSum(BigInteger num) {
		BigInteger sum = BigInteger.ZERO;
		while (num.compareTo(BigInteger.ZERO) > 0) {
			sum = sum.add(digitSum(num));
			num = num.subtract(BigInteger.ONE);
		}
		return sum;
	}

	private static BigInteger digitSum(BigInteger n) {
		if (n.compareTo(NINE) <= 9) {
//			return (n * (n + 1)) / 2;
			return n;
		}

		BigInteger addOn = n.mod(NINE);
		BigInteger res = n.divide(NINE);
		BigInteger result = new BigInteger(addOn + "" + res);
		while (res.compareTo(result) > 0) {
			// s += "9";
			res = res.subtract(BigInteger.ONE);
		}

		return calculateNum(res, addOn);

	}

	private static BigInteger calculateNum(BigInteger res, BigInteger addOn) {

		long val = 0, i = 0;
		/*
		 * while (res > 0) { val += 9 * (Math.pow(10, i)); res--; }
		 */

		String s = "";
		while (res.compareTo(BigInteger.ZERO) > 0) {
			s += "9";
			res = res.subtract(BigInteger.ONE);
		}
		s = addOn + s;
		return new BigInteger(s);
	}

	/*
	 * private static BigInteger fibonacciNo(long n) { long a = 0, b = 1, c = a + b;
	 * if (n == 1 || n == 2) { return BigInteger.ONE; } while (n > 2) { a = b; b =
	 * c; c = a + b; // System.out.println(c); n--; } return BigInteger.valueOf(c);
	 * }
	 */

}
