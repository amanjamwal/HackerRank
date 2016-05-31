package com.saambh.BV;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int prev = in.nextInt();
    StringBuilder sb = new StringBuilder();
    sb.append(prev);
    sb.append(" ");
    while (in.hasNextInt()) {
      int number = in.nextInt();
      int diff = number - prev;
      if (diff < -128) {
        sb.append("-128 ");
      }
      sb.append(diff);
      sb.append(" ");
      prev = number;
    }
    System.out.println(sb.toString());
  }
}
