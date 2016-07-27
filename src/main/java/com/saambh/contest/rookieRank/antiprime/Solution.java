package com.saambh.contest.rookieRank.antiprime;

import java.util.Scanner;

/**
 * Created by aman.jamwal on 27/07/16.
 *
 * An antiprime number is a number with a lot of divisors. Formally, a positive integer n is
 * antiprime if and only if it has more divisors than any other positive integer smaller than n.
 *
 * Given q queries where each query i is in the form of a single integer, ai, find and print the
 * smallest antiprime not smaller than ai on a new line.
 *
 * Input Format
 *
 * The first line contains a single integer, q, denoting the number of queries. Each line i of the q
 * subsequent lines contains a query in the form of a single integer, ai.
 *
 * Constraints
 *
 * 1<=q<=10^6 1<=ai<=10^7
 *
 * Output Format
 *
 * For each of the q queries, print the smallest antiprime not smaller than ai on a new line. This
 * means there will be a total of q lines of output.
 *
 * Sample Input
 *
 * 1 5
 *
 * Sample Output
 *
 * 6
 */
public class Solution {
  private static long[] antiprimes = {1, 2, 4, 6, 12,
				      24, 36, 48, 60, 120,
				      180, 240, 360, 720, 840,
				      1260, 1680, 2520, 5040, 7560,
				      10080, 15120, 20160, 25200, 27720,
				      45360, 50400, 55440, 83160, 110880,
				      166320, 221760, 277200, 332640, 498960,
				      554400, 665280, 720720, 1081080, 1441440,
				      2162160, 2882880, 3603600, 4324320, 6486480,
				      7207200, 8648640, 10810800, 14414400, 17297280,
				      21621600, 32432400, 36756720, 43243200, 61261200};

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    StringBuilder sb = new StringBuilder();
    while (q-- > 0) {
      sb.append(findNextAntiPrime(in.nextInt())).append("\n");
    }
    System.out.println(sb.toString());
    in.close();
  }

  private static long findNextAntiPrime(int key) {
    return find(antiprimes, 0, antiprimes.length - 1, key);
  }

  private static long find(long[] sortedArray, int l, int r, int key) {
    if (l == r) {
      if (sortedArray[l] >= key) {
	return sortedArray[l];
      } else {
	return sortedArray[l + 1];
      }
    }
    int mid = l + (r - l) / 2;
    if (sortedArray[mid] == key) {
      return sortedArray[mid];
    } else if (sortedArray[mid] > key) {
      return find(sortedArray, l, mid, key);
    } else {
      return find(sortedArray, mid + 1, r, key);
    }
  }
}
