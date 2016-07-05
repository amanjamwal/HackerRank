package com.saambh.contest.snackdown.KGood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartString {

  private String string;
  private int length;

  private Map<Tuple, Integer> cache;

  public SmartString(String string) {
    this.string = string;
    this.length = string.length();
    this.cache = new HashMap<>();
  }

  private static class Tuple {
    private int first;
    private int second;

    Tuple(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object object) {
      Tuple tuple = (Tuple) object;
      return this == tuple || (this.first == tuple.first && this.second == tuple.second);
    }

    @Override
    public int hashCode() {
      return Long.valueOf((((long) first) << 32) | second).hashCode();
    }
  }

  public int makeGoodWord(int k) {
    int[] charCount = new int[26];
    for (int i = 0; i < length; i++) {
      charCount[string.charAt(i) - 'a']++;
    }

    List<Integer> countList = new ArrayList<>(26);
    for (int i = 0; i < 26; i++) {
      if (charCount[i] > 0) {
        countList.add(charCount[i]);
      }
    }

    Collections.sort(countList);

    return findMin(countList, 0, countList.size(), k);
  }

  private int findMin(List<Integer> countList, int lower, int upper, int k) {
    Tuple tuple = new Tuple(lower, upper);
    if (cache.containsKey(tuple)) {
      return cache.get(tuple);
    }

    int min = 0;
    int lowerElimination = countList.get(lower);
    int upperElimination = countList.get(upper - 1) - countList.get(lower) - k;
    if (upperElimination > 0) {
      min = Math.min(lowerElimination + findMin(countList, lower + 1, upper, k),
                     upperElimination + findMin(countList, lower, upper - 1, k));
      cache.put(tuple, min);
    }
    return min;
  }

}
