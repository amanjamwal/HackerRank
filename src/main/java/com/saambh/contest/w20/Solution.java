package com.saambh.contest.w20;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int a[] = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }

    DivisiblePair divisiblePair = new DivisiblePair(n, a);

    System.out.println(divisiblePair.getCount(k));
  }
}
