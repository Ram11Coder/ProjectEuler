package com.euler;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a
 * 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25 20 7 8 9 10 19 6 1 2 11 18 5 4 3 12 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 *
 */
public class Problem28 {
/**
 * 1.Size of arrays is 1001, so it is a odd 
 * Middle row is intersection point of diagonal so one value 
 * other 1000 row have 2 diagonal element
 * (1000*2)+(1*1)->total 2001 elements are going to add
 * 
 * 2.what is the pattern 
 * 
21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

in the above triangle have 
middle element is 1
every clock rotation edges are diagonal elements
  1st clock -> 1
  2nd clock -> 3,5,7,9 -> common addition of 2 every elements
  3rd clock -> 13,17,21,25 -> common addition of 2+2 every elements
 4rd clock again (2+2+2)..
 ...
 
 so every clock wise iteration it adds 2
 
 3.How many time iterates>
 middle row -> 1 elements 
 1000 row with 2 diagonal elements
 1 iteration contains 4 elements
 1000*2 -> 2000 2 elements
 so 500*4 -> 500 clock wise iteration  
 each iteration adds numbers
 * 
 * 
 */
	public static void main(String[] args) {

		int row_col = 1001, sum = 1, total_sum = 1, adder = 0;
		adder += 2;
		for (int i = 0; i < row_col / 2; i++, adder += 2)
			for (int j = 0; j < 4; j++)
				// sum += adder;
				total_sum += sum += adder;
		System.out.println(total_sum);
	}

}
