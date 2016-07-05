package com.saambh.contest.BV.HotelList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HotelReview {
  private Set<String> keywordSet;

  private Map<Long, Integer> reviewKeywordMap;

  public HotelReview(String[] keywords) {
    this.keywordSet = new HashSet<>(keywords.length);
    for (String keyword : keywords) {
      keywordSet.add(keyword);
    }

    this.reviewKeywordMap = new TreeMap<>();
  }

  private Integer countMappedWords(String review) {
    String[] parsedReview = review.split("[^A-Za-z0-9]");
    int matchedCount = 0;
    for (String query : parsedReview) {
      if (keywordSet.contains(query)) {
        matchedCount++;
      }
    }
    return matchedCount;
  }

  public void addReview(Long hotelId, String review) {
    Integer matchedCount = countMappedWords(review);
    if (reviewKeywordMap.containsKey(hotelId)) {
      matchedCount += reviewKeywordMap.get(hotelId);
    }
    reviewKeywordMap.put(hotelId, matchedCount);
  }

  public String getSortedHotels() {
    Comparator<Map.Entry<Long, Integer>> customComparator = (o1, o2) -> {
      int value = o2.getValue().compareTo(o1.getValue());
      if (value == 0) {
        value = o1.getKey().compareTo(o2.getKey());
      }
      return value;
    };

    List<Map.Entry<Long, Integer>> hotelList = new ArrayList<>(reviewKeywordMap.entrySet());
    Collections.sort(hotelList, customComparator);

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Long, Integer> entry : hotelList) {
      sb.append(entry.getKey());
      sb.append(" ");
    }
    return sb.toString();
  }
}
