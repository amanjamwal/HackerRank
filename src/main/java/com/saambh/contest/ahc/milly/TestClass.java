package com.saambh.contest.ahc.milly;

import java.util.Scanner;

public class TestClass {
  public static void main(String[] args) {
    int[] lookUp = new int[1000001];
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    for (int i = 1, p = 0, j = 1; i <= n; i++) {
      int v = in.nextInt() + p;
      while (j <= v) {
	lookUp[j++] = i;
      }
      p = v;
    }
    int q = in.nextInt();
    while (q-- > 0) {
      System.out.println(lookUp[in.nextInt()]);
    }

    in.close();
  }
}
