package com.saambh.ds.graph.shortReach;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
  private int noOfVertices;
  private List<Integer>[] adjacencyList;

  public Graph(int noOfVertices) {
    this.noOfVertices = noOfVertices;
    this.adjacencyList = (List<Integer>[]) new List[noOfVertices + 1];
    for (int i = 1; i <= noOfVertices; i++) {
      this.adjacencyList[i] = new ArrayList<>();
    }
  }

  public void addEdge(int source, int destination) {
    this.adjacencyList[source].add(destination);
    this.adjacencyList[destination].add(source);
  }

  public String shortReach(int source) {
    int[] level = new int[noOfVertices + 1];
    for (int i = 1; i <= noOfVertices; i++) {
      level[i] = -1;
    }
    level[source] = 0;

    StringBuilder sb = new StringBuilder();

    int[] visited = new int[noOfVertices + 1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visited[source] = 1;

    while (!queue.isEmpty()) {
      Integer current = queue.poll();
      List<Integer> adjacentList = adjacencyList[current];

      int nextLevel = level[current] + 1;
      adjacentList.stream()
          .filter(vertex -> visited[vertex] == 0)
          .forEach(vertex -> {
            level[vertex] = nextLevel;
            queue.add(vertex);
            visited[vertex] = 1;
          });
    }

    for (int i = 1; i <= noOfVertices; i++) {
      if (i != source) {
        sb.append(level[i] > 0 ? level[i] * 6 : level[i]);
        sb.append(" ");
      }
    }

    return sb.toString();
  }
}
