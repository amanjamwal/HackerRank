package com.saambh.larry;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      CustomList customList = new CustomList(n);
      for (int i = 1; i <= n; i++) {
        customList.setValueInArray(i, in.nextInt());
      }
      System.out.println(customList.canFullySort() ? "YES" : "NO");
    }
  }
}