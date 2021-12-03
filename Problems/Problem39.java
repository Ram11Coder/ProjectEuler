package com.euler;

/**
 * If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * 
 *
 */
public class Problem39 {

	public static void main(String[] args) {
		int n = 1000;
		int count[] = new int[n + 1];
		for (int i = 1; i < 999; i++)
			for (int j = 1; j + i < 1000; j++)
				for (int k = 1; i + j + k < 1001; k++)
					if (((i * i) + (j * j)) == (k * k))
						count[(i + j + k)]++;

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++)
			if (max < count[i])
				max = i;
		System.out.println(max);
	}

}
