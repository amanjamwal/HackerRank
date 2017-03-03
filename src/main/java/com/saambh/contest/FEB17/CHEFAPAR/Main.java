package com.saambh.contest.FEB17.CHEFAPAR;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      boolean firstZeroEncountered = false;
      int noOfZeroes = 0;
      int due = 0;
      for (int i = 0; i < n; i++) {
        int x = in.nextInt();
        if (!firstZeroEncountered && x == 0) {
          firstZeroEncountered = true;
          due += (n - i) * 100;
        }

        if (x == 0) {
          noOfZeroes++;
        }
      }

      due += noOfZeroes * 1000;

      System.out.println(due);
    }
  }
}
