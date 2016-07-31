package com.saambh.contest.moonfrog.fitpainting;

import java.util.Scanner;

/**
 * You have 2 paintings of size a x b and c x d. You want to hang the paintings inside a rectangular
 * board on the wall. The board has dimensions n x m. You are allowed to rotate the paintings but at
 * least one edge of each of the paintings must be parallel to an edge of the board. The paintings
 * can touch each other and the edges of the board but cannot overlap or go beyond the edge of the
 * board. Is it possible to place the paintings on the board?
 *
 * Input: The input contains 3 lines in the form - n m a b c d First line contains space separated
 * integers n and m. Second line contains space separated integers a and b. Third line contains
 * space separated integers c and d.
 *
 * Output: If the paintings can be placed inside the board, print "Yes", print "No" otherwise.
 *
 * Constraints: All integers are in the range 1 to 1000.
 *
 * SAMPLE INPUT 3 2 1 3 2 1 SAMPLE OUTPUT Yes
 **/
class TestClass {
  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();

    System.out.println(canFit(n, m, a, b, c, d) ? "Yes" : "No");
  }

  private static boolean canFit(int n, int m, int a, int b, int c, int d) {
    if ((n * m < a * b + c * d) || (a > n && a > m) || (b > n && b > m) || (c > n && c > m) || (d > n && d > m)) {
      return false;
    }
    if (a <= n && b <= m) {
      if ((c <= n - a && d <= m) || (c <= n && d <= m - b) || (c <= m - b && d <= n) || (c <= m && d <= n - a)) {
	return true;
      }
    }

    if (a <= m && b <= n) {
      if ((c <= m - a && d <= n) || (c <= m && d <= n - b) || (c <= n - b && d <= m) || (c <= n && d <= m - a)) {
	return true;
      }
    }
    return false;
  }
}
