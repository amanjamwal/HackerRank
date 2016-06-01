package com.saambh.graph.shortReach;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      Graph graph = new Graph(n);
      int e = in.nextInt();
      for (int i = 0; i < e; i++) {
        int s = in.nextInt();
        int d = in.nextInt();
        graph.addEdge(s, d);
      }
      int s = in.nextInt();
      System.out.println(graph.shortReach(s));
    }
  }
}

