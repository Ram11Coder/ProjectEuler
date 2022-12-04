package com.euler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Smallest multiple
 * 
 * Problem 5
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any
 * remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 */
public class Problem5 {
  public static void main(String[] args) {
    int[] arr = IntStream.rangeClosed(1, 20).toArray();
    bruteForce();
    System.out.println(LcmOfArray(arr, 0));
  }

  // Recursive function to return gcd of a and b
  static long __gcd(long a, long b) {
    return b == 0 ? a : __gcd(b, a % b);
  }

  // recursive implementation
  static long LcmOfArray(int[] arr, int idx) {

    // lcm(a,b) = (a*b/gcd(a,b))
    if (idx == arr.length - 1) {
      return arr[idx];
    }
    long a = arr[idx];
    long b = LcmOfArray(arr, idx + 1);
    return (a * b / __gcd(a, b)); //

  }



  private static void bruteForce() {
    for (long i = 1; i < Long.MAX_VALUE; i++) {
      if (checkDivisiblebyAll20(i)) {
        System.out.println(i);
        break;
      }
    }
  }

  private static boolean checkDivisiblebyAll20(long num) {
    for (int i = 2; i <= 20; i++)
      if (num % i != 0)
        return false;
    return true;
  }
}
