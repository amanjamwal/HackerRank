package com.saambh.contest.snackdown.MMSum;

class MMSuma {
  private int size;
  private long array[];

  public MMSuma(int size, long array[]) {
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
      long cumulative = term > array[i] ? term : array[i];

      long modifiedCumulative = Math.max(previousTuple.max,
                                         previousTuple.modifiedMax + array[i]);

      cumulativeArray[i] = new Tuple(modifiedCumulative, cumulative);
      max = max < modifiedCumulative ? modifiedCumulative : max;
    }
    return max;
  }
}
