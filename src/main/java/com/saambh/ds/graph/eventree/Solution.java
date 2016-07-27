package com.saambh.ds.graph.eventree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aman.jamwal on 26/07/16.
 *
 * You are given a tree (a simple connected graph with no cycles). The tree has N nodes numbered
 * from 1 to N.
 *
 * Find the maximum number of edges you can remove from the tree to get a forest such that each
 * connected component of the forest contains an even number of vertices.
 *
 * Input Format
 *
 * The first line of input contains two integers N and M. N is the number of vertices, and M is the
 * number of edges. The next  lines contain two integers ui and vi which specifies an edge of the
 * tree.
 *
 * Output Format
 *
 * Print the number of removed edge.
 *
 * Constraints
 *
 * 2<=N<=100
 *
 * Note: The tree in the input will be such that it can always be decomposed into components
 * containing an even number of nodes.
 *
 * Sample Input
 *
 * 10 9 2 1 3 1 4 3 5 2 6 1 7 2 8 6 9 8 10 8
 *
 * Sample Output
 *
 * 2
 *
 * Explanation
 *
 * On removing edges  and , we can get the desired result.
 */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    Graph graph = new Graph(n);
    while (m-- > 0) {
      graph.addEdge(in.nextInt(), in.nextInt());
    }
    System.out.println(graph.makeEvenTreeForest());
    in.close();
  }

  private static class Graph {
    private List<Integer>[] edges;
    private int size;
    private int deletions;

    Graph(int n) {
      this.size = n;
      this.edges = (List<Integer>[]) new List[n + 1];
      for (int i = 1; i <= n; i++) {
	this.edges[i] = new ArrayList<>();
      }
      this.deletions = 0;
    }

    public void addEdge(int firstVertex, int secondVertex) {
      edges[firstVertex].add(secondVertex);
      edges[secondVertex].add(firstVertex);
    }

    public int makeEvenTreeForest() {
      makeEvenTreeForest(1, new boolean[size + 1]);
      return deletions;
    }

    private int makeEvenTreeForest(int vertex, boolean[] visited) {
      int nodeCount = 1;
      visited[vertex] = true;
      for (int adjVertex : edges[vertex]) {
	if (!visited[adjVertex]) {
	  int count = makeEvenTreeForest(adjVertex, visited);
	  if (count % 2 == 0) {
	    deletions += 1;
	  }
	  nodeCount += count;
	}
      }
      return nodeCount;
    }
  }
}
