package com.saambh.contest.snackdown.KGood;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String s = in.next();
      int k = in.nextInt();
      SmartString smartString = new SmartString(s);
      System.out.println(smartString.makeGoodWord(k));
    }
  }
}
