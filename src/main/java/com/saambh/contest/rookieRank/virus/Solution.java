package com.saambh.contest.rookieRank.virus;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by aman.jamwal on 26/07/16.
 */
public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();
    long t = in.nextLong();

    System.out.println(findCount(a, b, t));

    in.close();
  }

  private static int findCount(int a, int b, long t) {
    int c = (a + b) / 2;
    return new BigInteger(String.valueOf(c))
	.modPow(new BigInteger(String.valueOf(t)),
		new BigInteger(String.valueOf(1000000007)))
	.intValue();
  }
}