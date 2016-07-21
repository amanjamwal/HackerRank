package com.saambh.contest.ahc.vyasa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClass {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    long[] k = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      k[i] = in.nextLong();
    }

    CustomDisjointSet ds = new CustomDisjointSet(n, k);

    for (int i = 0; i < m; i++) {
      int node1 = in.nextInt();
      int node2 = in.nextInt();
      ds.union(node1, node2);
    }

    List<Long> finalLeaders = ds.differentLeaderCounts();
    long p = 1;
    for (long lc : finalLeaders) {
      p = (p * lc) % 1000000007;
    }
    System.out.println(p);
    in.close();
  }
}

class CustomDisjointSet {
  private int[] leaders;
  private long[] leadersCount;
  private long[] knowledge;

  CustomDisjointSet(int size, long[] knowledge) {
    this.leaders = new int[size + 1];
    this.leadersCount = new long[size + 1];
    for (int i = 1; i <= size; i++) {
      this.leaders[i] = i;
      this.leadersCount[i] = 1;
    }
    this.knowledge = knowledge;
  }

  public List<Long> differentLeaderCounts() {
    List<Long> leaderCount = new ArrayList<Long>();
    for (int i = 1; i < leaders.length; i++) {
      if (leaders[i] == i) {
	leaderCount.add(leadersCount[i]);
      }
    }
    return leaderCount;
  }

  public int find(int node) {
    if (leaders[node] != node) {
      leaders[node] = find(leaders[node]);
    }
    return leaders[node];
  }

  public void union(int node1, int node2) {
    int leader1 = find(node1);
    int leader2 = find(node2);

    if (knowledge[leader1] < knowledge[leader2]) {
      leaders[leader1] = leader2;
    } else if (knowledge[leader2] < knowledge[leader1]) {
      leaders[leader2] = leader1;
    } else {
      leaders[leader2] = leader1;
      leadersCount[leader1] += leadersCount[leader2];
    }
  }
}
