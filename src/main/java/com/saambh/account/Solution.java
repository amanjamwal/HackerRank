package com.saambh.account;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[m];
    for (int i = 0; i < m; i++) {
      a[i] = in.nextInt();
    }
    Wallet wallet = new Wallet(m, a);
    System.out.println(wallet.noOfWays(n));
  }
}