package com.saambh.w20;

import java.util.HashMap;
import java.util.Map;

public class DivisiblePair {

  private int size;
  private int array[];

  public DivisiblePair(int size, int array[]) {
    this.size = size;
    this.array = array;
  }

  public int getCount(int k) {
    int result = 0;
    Map<Integer, Integer> otherMap = new HashMap<>(k);
    for (int a_i = 0; a_i < size; a_i++) {
      int value = array[a_i] % k;
      if (otherMap.containsKey(value)) {
        result += otherMap.get(value);
      }

      int diff = (k - value) % k;
      int count = otherMap.containsKey(diff) ? otherMap.get(diff) + 1 : 1;
      otherMap.put(diff, count);
    }
    return result;
  }

}
