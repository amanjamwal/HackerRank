package com.saambh.contest.ahc;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] cum = new int[n];
    for (int i = 0, prev = 0; i < n; i++) {
      cum[i] = in.nextInt() + prev;
      prev = cum[i];
    }
    int q = in.nextInt();
    while (q-- > 0) {
      System.out.println(search(in.nextInt(), cum) + 1);
    }
    in.close();
  }

  private static int search(int key, int[] cum) {
    return search(key, cum, 0, cum.length - 1);
  }

  private static int search(int key, int[] cum, int l, int r) {
    if (l > r) {
      return -1;
    }

    if (l == r) {
      if(cum[l] >= key){
        return l;
      } else{
        return -1;
      }
    }

    int m = (l + r) / 2;
    if (cum[m] == key) {
      return m;
    } else if (cum[m] < key) {
      return search(key, cum, m + 1, r);
    } else if (cum[m] > key) {
      if (m - 1 >= 0 && cum[m - 1] < key) {
	return m;
      } else {
	return search(key, cum, l, m - 1);
      }
    }
    return -1;
  }
}
