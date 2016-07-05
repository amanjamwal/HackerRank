package com.saambh.contest.snackdown.KTTable;

import java.util.Scanner;

public class Main {

  //Driver for KTTable
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      long a[] = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        a[i] = in.nextLong();
      }

      long b[] = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        b[i] = in.nextLong();
      }

      KTTable ktTable = new KTTable(n, a, b);

      System.out.println(ktTable.countOfCooking());
    }
  }
}

