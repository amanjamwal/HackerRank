package com.saambh.contest.moonfrog.special_path;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * You are given a rectangular grid with n rows and m columns. The rows are numbered 1 to n, from
 * bottom to top, and the columns are numbered 1 to m, from left to right.
 *
 * You are also given k special fields in the form (row, column). For each i, where 0 <= i <= k,
 * count the number of different paths from (1, 1) to (n, m) that contains exactly n special
 * fields.
 *
 * There is one rule you must follow. You are only allowed to make moves that are straight up or to
 * the right. In other words, from each field (row, column), you can only move to field (row+1,
 * column) or field (row, column+1).
 *
 * Output an array of k + 1 elements. The i-th element (0-indexed) must be the number of different
 * paths that contain exactly i special fields. Since, the answer can be too big, output it modulo
 * 1000007.
 *
 * Input: First line contains three space separated integers, n, m and k. Next k lines, each contain
 * two space separated integers, the coordinates of a special field.
 *
 * Output: k + 1 space separated integers, the answer to the question.
 *
 * Constraints:
 *
 * 1 <= n, m, k <= 100
 *
 * For all coordinates (r, c) - 1 <= r <= n, 1 <= c <= m
 *
 * All coordinates are valid and different.
 *
 * SAMPLE INPUT
 *
 * 3 3 2 2 2 3 2
 *
 * SAMPLE OUTPUT
 *
 * 1 3 2
 **/
class TestClass {
  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    SpecialGrid sg = new SpecialGrid(n, m, k);
    while (k-- > 0) {
      int x = in.nextInt();
      int y = in.nextInt();
      sg.addSpecialPoint(x - 1, y - 1);
    }
    System.out.println(sg.findFrequency());
  }
}

class SpecialGrid {
  private int n;
  private int m;
  private int k;

  private Set<Coordinate> specialPoints;
  private int[] counts;

  private int[][][] dp;
  private boolean[][] isVisited;

  SpecialGrid(int n, int m, int k) {
    this.n = n;
    this.m = m;
    this.k = k;
    this.specialPoints = new HashSet<>(k);
    this.dp = new int[n][m][k + 1];
    this.isVisited = new boolean[n][m];
  }

  public void addSpecialPoint(int x, int y) {
    this.specialPoints.add(new Coordinate(x, y));
  }

  public String findFrequency() {
    counts = findFrequency(0, 0);
    StringBuilder sb = new StringBuilder();
    for (int c : counts) {
      sb.append(c).append(" ");
    }
    return sb.toString();
  }

  private int[] findFrequency(int x, int y) {
    if (!isVisited[x][y]) {

      boolean isSpecial = specialPoints.contains(new Coordinate(x, y));

      if (x == n - 1 && y == m - 1) {
	if (isSpecial) {
	  dp[x][y][1] = 1;
	} else {
	  dp[x][y][0] = 1;
	}
      } else {

	int[] left = (x + 1 < n) ? findFrequency(x + 1, y) : new int[k + 1];
	int[] right = (y + 1 < m) ? findFrequency(x, y + 1) : new int[k + 1];

	if (isSpecial) {
	  for (int i = 0; i < k; i++) {
	    dp[x][y][i + 1] = (left[i] + right[i]) % 1000007;
	  }
	} else {
	  for (int i = 0; i <= k; i++) {
	    dp[x][y][i] = (left[i] + right[i]) % 1000007;
	  }
	}
      }
      isVisited[x][y] = true;
    }
    return dp[x][y];
  }

  private static class Coordinate {
    private int x;
    private int y;

    private Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object object) {
      Coordinate coordinate = (Coordinate) object;
      return this == coordinate || (this.x == coordinate.x && this.y == coordinate.y);
    }

    @Override
    public int hashCode() {
      return 31 * x + y;
    }
  }
}
