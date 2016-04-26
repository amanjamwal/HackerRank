package com.saambh.costing;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    long q = in.nextLong();
    SideTree fullTree = new SideTree();
    while (n-- > 1) {
      long v1 = in.nextLong();
      long v2 = in.nextLong();
      long w = in.nextLong();
      fullTree.addWeightedEdge(v1, v2, w);
    }
    while (q-- > 0) {
      long l = in.nextLong();
      long h = in.nextLong();
      System.out.println(fullTree.getCount(l, h));
    }
  }
}