package com.saambh.june_wc.Kangaroo;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x1 = in.nextInt();
    int v1 = in.nextInt();
    int x2 = in.nextInt();
    int v2 = in.nextInt();
    int diffX = x2 - x1;
    int diffV = v1 - v2;

    boolean willMeet = diffX == 0 && diffV == 0;
    if (diffX < 0 && diffV < 0 || diffX > 0 && diffV > 0) {
      willMeet = diffX % diffV == 0;
    }
    System.out.println(willMeet ? "YES" : "NO");
    in.close();
  }
}