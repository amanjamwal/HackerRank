package com.saambh.morgan;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String a = in.next();
      String b = in.next();
      JackDaniel jd = new JackDaniel(a, b);
      System.out.println(jd.morganString());
    }
  }
}