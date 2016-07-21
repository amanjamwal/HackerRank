package com.saambh.ds.advanced.FenwickTree;

import java.util.Scanner;

/**
 * Created by aman.jamwal on 18/07/16. 6 1 2 5 7 9 11 1 1 3 2 0 2
 */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = in.nextInt();
    }
    IFenwickTree fenwickTree = new FenwickTree(array);
    int u = in.nextInt();
    while (u-- > 0) {
      int i = in.nextInt();
      int v = in.nextInt();
      fenwickTree.update(i, v);
    }
    int q = in.nextInt();
    while (q-- > 0) {
      int l = in.nextInt();
      int r = in.nextInt();
      System.out.println(fenwickTree.getSum(r) - fenwickTree.getSum(l - 1));
    }
    in.close();
  }
}

interface IFenwickTree {
  int getSum(int index);

  void update(int index, int val);
}

class FenwickTree implements IFenwickTree {

  private int[] BITree;
  private int[] rawValues;
  private int size;

  FenwickTree(int[] rawValues) {
    this.rawValues = rawValues;
    this.size = rawValues.length;
    this.BITree = new int[size + 1];
    build();
  }

  private void build() {
    for (int i = 0; i < size; i++) {
      internalUpdate(i, rawValues[i]);
    }
  }

  private void internalUpdate(int index, int val) {
    index++;

    while (index <= size) {
      this.BITree[index] += val;
      index += (index & -index);
    }
  }

  @Override
  public int getSum(int index) {
    int sum = 0;
    index++;
    while (index > 0) {
      sum += this.BITree[index];
      index -= (index & -index);
    }
    return sum;
  }

  @Override
  public void update(int index, int val) {
    int diff = val - rawValues[index];
    this.rawValues[index] = val;
    internalUpdate(index, diff);
  }
}
