package com.saambh.dp.MaxSubArray;

public class CustomList {
  private long[] array;
  private int size;

  public CustomList(int size, long array[]) {
    this.size = size;
    this.array = array;
  }

  public long maxContiguousSubArray() {

    if (size == 0) {
      return 0;
    }

    long cumulative[] = new long[size];
    cumulative[0] = array[0];
    long max = array[0];

    for (int i = 1; i < size; i++) {
      long cumulativeValue = cumulative[i - 1] + array[i];
      cumulative[i] = cumulativeValue > array[i] ? cumulativeValue : array[i];
      max = max > cumulative[i] ? max : cumulative[i];
    }
    return max;
  }

  public long maxSubArray() {
    if (size == 0) {
      return 0;
    }

    long max = array[0];

    for (int i = 1; i < size; i++) {
      long cumulative = max + array[i];
      max = cumulative > max ? cumulative : max;
      max = array[i] > max ? array[i] : max;
    }
    return max;
  }
}
