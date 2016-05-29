package com.saambh.snackdown.MMSum;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int a[] = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        a[i] = in.nextInt();
      }

      MMSum mmSum = new MMSum(n, a);

      System.out.println(mmSum.maxAfterEdit());
    }
  }
}

