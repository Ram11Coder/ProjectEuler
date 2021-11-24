package com.euler;

/**
 * Number letter counts Problem 17
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 *
 *
 */
public class Problem17 {

	public static final String[] ONES = { "", "One", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten" };
	public static final String[] TWO_DIGITS = { "Ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen", "twenty" };
	public static final String[] TENS = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };
	public static final String[] HUNDREDS = { "hundred" };
	public static final String[] THOUSAND = { "Thousand" };

	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i <= 1000; i++)
			sum += numberToWordsConversion(i).length();
		System.out.println(sum);
	}

	private static String numberToWordsConversion(int n) {
		int len = String.valueOf(n).length();
		if (n == 0)
			return "Zero";
		if (len == 1)
			return getOnes(n);
		else if (len == 2)
			return getTWO_DIGITS(n, len);
		else if (len == 3)
			return getHundreds(n, len);
		else if (len == 4)
			return getThousand(n, len);
		else
			return "Number not in the range[1 - 9999]";

	}

	public static String getThousand(int n, int len) {
		String s = "";
		int val = (int) (n % (Math.pow(10, len - 1)));
		int num = (int) (n / (Math.pow(10, len - 1)));
		s = getOnes(num) + THOUSAND[0]
				+ ((val < 10) ? getOnes(val) : (val < 100) ? getTWO_DIGITS(val, len - 1) : getHundreds(val, len - 1));
		return s;
	}

	private static String getHundreds(int num, int len) {
		int n = (int) (num % Math.pow(10, len - 1));
		num = (int) (num / Math.pow(10, len - 1));
		return (n == 0) ? getOnes(num) + HUNDREDS[0]
				: (n > 10) ? getOnes(num) + HUNDREDS[0] + "and" + getTWO_DIGITS(n, len - 1)
						: getOnes(num) + HUNDREDS[0] + "and" + getOnes(n);
	}

	private static String getTWO_DIGITS(int num, int len) {
		if (num >= 20)
			return (num % 10 == 0) ? getTens(num / 10) : getTens(num / 10) + getOnes(num % 10);
		return TWO_DIGITS[num % 10];
	}

	private static String getTens(int n) {
		return TENS[n];
	}

	private static String getOnes(int n) {
		return ONES[n];
	}

}
