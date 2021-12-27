package com.euler;

/**
 * Starting with 1 and spiralling anticlockwise in the following way, a square
 * spiral with side length 7 is formed.
 * 
37 36 35 34 33 32 31
38 17 16 15 14 13 30
39 18  5  4  3 12 29
40 19  6  1  2 11 28
41 20  7  8  9 10 27
42 21 22 23 24 25 26
43 44 45 46 47 48 49

 * It is interesting to note that the odd squares lie along the bottom right
 * diagonal, but what is more interesting is that 8 out of the 13 numbers lying
 * along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.
 * 
 * If one complete new layer is wrapped around the spiral above, a square spiral
 * with side length 9 will be formed. If this process is continued, what is the
 * side length of the square spiral for which the ratio of primes along both
 * diagonals first falls below 10%?
 *
 */
public class Problem58 {
	public static void main(String[] args) {
		int c = 2, count = 0, primes = 0, square_count = 0;
		double percentage = 0;
		for (int i = 3; i <= 1_000_000_000; i += c) {
			if (isPrime(i))
				primes++;

			count++;
			if (count % 4 == 0) {
				square_count++;
				c += 2;
				percentage = ((double) primes / (count + 1)) * 100;
			}
			if (count > 5 && percentage < 10.0)
				break;
		}
		System.out.println(square_count * 2 + 1);//Diagonal side length 
	int cnt=0;
	for (int i = 79; i < 1601; i+=2) {
		if(isPrime(i))
cnt++;
	}
	System.out.println(cnt);
	}

	private static boolean isPrime(int n) {
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6)
			if (n % i == 0 || (n % (i + 2) == 0))
				return false;

		return true;
	}
}
