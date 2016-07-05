package com.saambh.contest.snackdown.MMSum;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      long a[] = new long[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextLong();
      }

      MMSum mmSum = new MMSum(n, a);

      System.out.println(mmSum.maxSubsetSum());
    }
  }
}

class MMSum {
  private int size;
  private long array[];

  public MMSum(int size, long array[]) {
    this.size = size;
    this.array = array;
  }

  private static class Tuple {
    private long modifiedMax;
    private long max;

    public Tuple(long modifiedMax, long max) {
      this.modifiedMax = modifiedMax;
      this.max = max;
    }
  }

  public long maxSubsetSum() {
    Tuple[] cumulativeArray = new Tuple[size];
    cumulativeArray[0] = new Tuple(0, array[0]);
    long max = Long.MIN_VALUE;
    for (int i = 1; i < size; i++) {
      Tuple previousTuple = cumulativeArray[i - 1];
      long term = previousTuple.max + array[i];
      long cumulative = Math.max(term, array[i]);

      term = previousTuple.modifiedMax + array[i];
      long modifiedCumulative = Math.max(previousTuple.max,
                                         Math.max(term, array[i]));

      cumulativeArray[i] = new Tuple(modifiedCumulative, cumulative);
      max = Math.max(max, Math.max(cumulative, modifiedCumulative));
    }
    return max;
  }
}


