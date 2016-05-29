package com.saambh.snackdown.MMSum;

public class MMSum {
  private int n;
  private int a[];

  public MMSum(int n, int a[]) {
    this.n = n;
    this.a = a;
  }

  private static int maxSubsetSum(int size, int[] array) {

    int ca[] = new int[size + 1];

    int max = Integer.MIN_VALUE / 2;
    int s = 0;
    for (int i = 1; i <= size; i++) {
      int cum = ca[s] + array[i];
      ca[i] = cum > 0 ? cum : array[i];
      max = cum > max ? cum : max;
      s = cum > 0 ? i : 0;
    }
    return max;
  }

  public int maxAfterEdit() {
    int cumulativeSumArray[] = new int[n + 2];
    int cCounter = 1;
    int negatives[] = new int[n + 1];
    int nCounter = 0;

    int cum = 0;
    int minValue = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      if (a[i] < 0) {
        if (cum > 0) {
          cumulativeSumArray[cCounter++] = cum;
          cum = 0;
        }
        cumulativeSumArray[cCounter++] = a[i];
        negatives[nCounter++] = cCounter - 1;
      } else {
        cum += a[i];
      }
      if (a[i] < minValue) {
        minValue = a[i];
      }
    }

    if (cum > 0) {
      cumulativeSumArray[cCounter++] = cum;
    }

    //Iterate removing each trough
    int minIndex = -1;
    int max = Integer.MIN_VALUE / 2;
    for (int i = 0; i < nCounter; i++) {
      int sum = cumulativeSumArray[negatives[i] - 1] + cumulativeSumArray[negatives[i] + 1];
      if (sum > max) {
        max = sum;
        minIndex = negatives[i];
      }
    }

    int b[] = new int[n + 1];
    int bCounter = 1;
    for (int i = 1; i < cCounter; i++) {
      if (i != minIndex) {
        b[bCounter++] = cumulativeSumArray[i];
      }
    }

    int newMax = maxSubsetSum(bCounter - 1, b);
    return nCounter > 0 ? newMax : newMax - minValue;
  }
}
