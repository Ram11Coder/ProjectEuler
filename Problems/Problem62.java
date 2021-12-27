package com.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes:
 * 56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest cube
 * which has exactly three permutations of its digits which are also cube.
 * 
 * Find the smallest cube for which exactly five permutations of its digits are
 * cube.
 *
 */
public class Problem62 {
	static int count = 0;
	static Set<Long> setList = new HashSet<Long>();
	static List<BigInteger> biList = new ArrayList<BigInteger>();

	/*
	 * static {
	 * 
	 * for (long i = 5000; i < 5500; i++) { if (i % 10 != 0) { BigInteger val =
	 * BigInteger.valueOf(i); biList.add(val.multiply(val).multiply(val)); } } }
	 */
	public static void main(String[] args) {
		long cubeCount = 5;
		// for (BigInteger i = BigInteger.valueOf(start);
		// i.compareTo(BigInteger.valueOf(100_000))<=0; i=i.add(BigInteger.ONE)) {
		// BigInteger cube = i.multiply(i).multiply(i);

//		for (int i=1000;i< biList.size();i++) {
//			BigInteger cube=biList.get(i);
		// if (String.valueOf(cube).length() > 8) {
		/*
		 * for (BigInteger cube : biList){ permuatateCubes((cube) + "", 0,
		 * String.valueOf(cube).length(), cube); if (count == cubeCount) {
		 * System.out.println(cube); break; } System.out.println(cube + " : " + count);
		 * count = 0; setList.clear(); // } }System.out.println(count);
		 * 
		 * }
		 */

		// permuatateCubes((41063625) + "", 0, String.valueOf(41063625).length(), new
		// BigInteger(41063625 + ""));
		BigInteger cube = BigInteger.valueOf(5027L * 5027L * 5027L);
		permuatateCubes((cube) + "", 0, String.valueOf(cube).length(), cube);
		System.out.println(count);
	}

	private static void permuatateCubes(String num, int start, int len, BigInteger edgecase) {
		if (start == len) {
			if (setList.add(Long.parseLong(num)))
				isCube(num);

		} else {
			for (int i = start; i < len; i++) {
				num = swap(num, i, start);
				permuatateCubes(num, start + 1, len, edgecase);
				num = swap(num, i, start);
			}
		}
	}

	public static boolean isCubeCheck(String num, int n) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}
		int val = (sum > n) ? (sum - n) % 3 : (n - sum) % 3;
		return val == 0;
	}

	private static void isCube(String num) {
		/*
		 * long limit = (long) Math.sqrt(cube) / 3; while (limit > edge) { if ((limit *
		 * limit * limit) == cube) { count++; //System.out.println(cube + " : " +
		 * count); } limit--; }
		 */
		if (biList.indexOf(new BigInteger(num)) != -1)
			count++;
	}

	private static String swap(String num, int i, int s) {
		char ch[] = num.toCharArray();
		char c = ch[i];
		ch[i] = ch[s];
		ch[s] = c;
		return String.valueOf(ch);
	}
}
