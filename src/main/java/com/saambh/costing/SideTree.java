package com.saambh.costing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Math.max;

public class SideTree {
  private Map<Long, Set<Edge<Long>>> setMap;
  private Map<Long, Long> countMap;

  public SideTree() {
    this.setMap = new ConcurrentHashMap<>();
    this.countMap = new TreeMap<>();
  }

  public void addWeightedEdge(Long s, Long d, Long w) {
    Set<Edge<Long>> dEdgeSet = new HashSet<>();
    dEdgeSet.add(getNewEdge(s, d, w));

    Set<Edge<Long>> firstEdgeSet = getEdgeSet(s);
    for (Edge<Long> e : firstEdgeSet) {
      Long otherVertex = e.getOtherVertex(s);
      Edge<Long> newEdge = getNewEdge(d, otherVertex, max(w, e.getWeight()));
      dEdgeSet.add(newEdge);
    }

    Set<Edge<Long>> nEdgeSet = new HashSet<>();
    Set<Edge<Long>> secondEdgeSet = getEdgeSet(d);
    for (Edge<Long> dEdge : dEdgeSet) {
      for (Edge<Long> eEdge : secondEdgeSet) {
        Long uVertex = dEdge.getOtherVertex(d);
        Long vVertex = eEdge.getOtherVertex(d);
        Edge<Long> newEdge = getNewEdge(uVertex,
                                        vVertex,
                                        max(dEdge.getWeight(), eEdge.getWeight()));

        nEdgeSet.add(newEdge);
      }
    }

    dEdgeSet.addAll(secondEdgeSet);
    for (Edge<Long> e : dEdgeSet) {
      setMap.get(e.getFirstVertex()).add(e);
      setMap.get(e.getSecondVertex()).add(e);
    }

    for (Edge<Long> e : nEdgeSet) {
      setMap.get(e.getFirstVertex()).add(e);
      setMap.get(e.getSecondVertex()).add(e);
    }
  }

  private Edge<Long> getNewEdge(Long s, Long d, Long w) {
    addCount(w, 1L);
    return new Edge<>(s, d, w);
  }

  private void addCount(Long w, Long l) {
    Long currentCount = countMap.containsKey(w) ? countMap.get(w) : 0L;
    countMap.put(w, currentCount + l);
  }

  private Set<Edge<Long>> getEdgeSet(Long s) {
    if (!setMap.containsKey(s)) {
      setMap.put(s, new HashSet<>());
    }
    return setMap.get(s);
  }

  public Long getCount(Long l, Long r) {
    Long sum = 0L;
    for (Long k : countMap.keySet()) {
      if (k > r) {
        return sum;
      } else if (k >= l) {
        sum += countMap.get(k);
      }
    }
    return sum;
  }
}
