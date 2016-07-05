package com.saambh.contest.snackdown.KTTable;

public class KTTable {
  private int n;
  private long a[];
  private long b[];

  public KTTable(int n, long a[], long b[]) {
    this.n = n;
    this.a = a;
    this.b = b;
  }

  public int countOfCooking() {

    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (b[i] <= a[i] - a[i - 1]) {
        count++;
      }
    }
    return count;
  }
}
