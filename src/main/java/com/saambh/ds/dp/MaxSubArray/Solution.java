package com.saambh.ds.dp.MaxSubArray;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      long[] list = new long[n];
      for (int i = 0; i < n; i++) {
        list[i] = in.nextLong();
      }
      CustomList customList = new CustomList(n, list);
      System.out.println(customList.maxContiguousSubArray() + " " + customList.maxSubArray());
    }
  }
}

