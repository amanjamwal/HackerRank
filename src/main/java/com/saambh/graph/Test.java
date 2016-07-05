package com.saambh.graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Test {
  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Graph graph = new Graph(n);
    int m = in.nextInt();
    while (m-- > 0) {
      int v1 = in.nextInt();
      int v2 = in.nextInt();
      graph.addEdge(v1, v2);
    }

    int q = in.nextInt();
    while (q-- > 0) {
      int v1 = in.nextInt();
      int v2 = in.nextInt();
      System.out.println(graph.hasEdgeBetween(v1, v2) ? "YES" : "NO");
    }
  }
}

class Graph {
  //private List<Integer> nodes;
  private int noOfNodes;
  private Set<Edge> edges;

  Graph(int n) {
    this.noOfNodes = n;
    this.edges = new HashSet<>();
  }

  void addEdge(int node1, int node2) {
    this.edges.add(new Edge(node1, node2));
  }

  boolean hasEdgeBetween(int node1, int node2) {
    return this.edges.contains(new Edge(node1, node2));
  }

  private static class Edge {
    private Integer node1;
    private Integer node2;

    Edge(Integer node1, Integer node2) {
      this.node1 = node1;
      this.node2 = node2;
    }

    @Override
    public boolean equals(Object object) {
      Edge edge = (Edge) object;
      return this == edge ||
	  (this.node1.intValue() == edge.node1.intValue() && this.node2.intValue() == edge.node2
	      .intValue()) ||
	  (this.node1.intValue() == edge.node2.intValue() && this.node2.intValue() == edge.node1
	      .intValue());
    }

    @Override
    public int hashCode() {
      if (node1 < node2) {
	return 31 * node1.hashCode() + node2.hashCode();
      } else {
	return 31 * node2.hashCode() + node1.hashCode();
      }
    }

    boolean hasNode(Integer node) {
      return node1.intValue() == node.intValue() || node2.intValue() == node.intValue();
    }

    Integer otherNode(Integer node) {
      if (!hasNode(node)) {
	return -1;
      } else if (node1.intValue() == node.intValue()) {
	return node2;
      } else {
	return node1;
      }
    }
  }
}