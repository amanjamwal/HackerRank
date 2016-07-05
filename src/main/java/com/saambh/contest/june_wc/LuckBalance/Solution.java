package com.saambh.contest.june_wc.LuckBalance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int k = in.nextInt();

    List<Integer> kList = new ArrayList<>();
    int totalL = 0;
    for (int i = 0; i < n; i++) {
      int l = in.nextInt();
      int t = in.nextInt();
      if (t == 1) {
	kList.add(l);
      }
      totalL += l;
    }
    Collections.sort(kList);
    int i = 0;
    while (i < k && i < kList.size()) {
      i++;
    }
    for (int j = 0; i < kList.size(); i++, j++) {
      totalL -= 2 * kList.get(j);
    }
    System.out.println(totalL);
    in.close();
  }
}