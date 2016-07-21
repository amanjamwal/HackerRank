package com.saambh.ds.advanced.SegTree;

import java.util.Scanner;

/**
 * Created by aman.jamwal on 18/07/16.
 *
 * 6
 1 2 5 7 9 11
 1
 1 3
 2
 0 2
 */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = in.nextInt();
    }
    ISegTree<Integer> segTree = new SegTree(array);
    int u = in.nextInt();
    while (u-- > 0) {
      int i = in.nextInt();
      int v = in.nextInt();
      segTree.update(i, v);
    }
    int q = in.nextInt();
    while (q-- > 0) {
      int l = in.nextInt();
      int r = in.nextInt();
      System.out.println(segTree.query(l, r));
    }
    in.close();
  }
}

interface ISegTree<T> {
  void update(int leafIndex, T data);

  T query(int left, int right);
}

class SegTree implements ISegTree<Integer> {
  private int[] fullTree;
  private int[] leaves;
  private int size;

  SegTree(int[] leaves) {
    this.leaves = leaves;
    int x = (int) (Math.ceil(Math.log(leaves.length) / Math.log(2)));
    this.size = 2 * (int) Math.pow(2, x) - 1;
    this.fullTree = new int[size];
    init();
  }

  private void init() {
    int left = 0;
    int right = leaves.length - 1;
    build(0, left, right);
  }

  private void build(int index, int left, int right) {
    if (left == right) {
      fullTree[index] = leaves[left];
    } else {
      int mid = (left + right) / 2;
      build(index * 2 + 1, left, mid);
      build(index * 2 + 2, mid + 1, right);
      fullTree[index] = fullTree[index * 2 + 1] + fullTree[index * 2 + 2];
    }
  }

  @Override
  public void update(int leafIndex, Integer data) {
    int diff = data - leaves[leafIndex];
    leaves[leafIndex] += diff;
    update(0, 0, leaves.length - 1, leafIndex, diff);
  }

  private void update(int index, int left, int right, int leafIndex, int diff) {
    fullTree[index] += diff;
    if (left != right) {
      int mid = left + (right - left) / 2;
      if (leafIndex <= mid) {
	update(index * 2 + 1, left, mid, leafIndex, diff);
      } else {
	update(index * 2 + 2, mid + 1, right, leafIndex, diff);
      }
    }
  }

  private Integer query(int index, int left, int right, int qLeft, int qRight) {
    if (qLeft <= left && qRight >= right) {
      return fullTree[index];
    }

    if (qRight < left || qLeft > right) {
      return 0;
    }

    int mid = (left + right) / 2;
    return query(index * 2 + 1, left, mid, qLeft, qRight) + query(index * 2 + 2, mid + 1, right,
								  qLeft, qRight);
  }

  @Override
  public Integer query(int left, int right) {
    return query(0, 0, leaves.length - 1, left, right);
  }
}
