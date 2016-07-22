package com.saambh.ds.advanced.SegTree.comrades;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aman.jamwal on 22/07/16.
 *
 * It’s the year 2552, the Humans just won a war against a very powerful alien race that had invaded
 * our solar system. The Human army is in celebration mode!
 *
 * The army has n soldiers. The soldiers are numbers from 1 to n. The army has a superiority
 * hierarchy. Every soldier has one immediate superior. The superior of a superior of a soldier is
 * also a superior to that soldier. So, a soldier may have one or more superiors but only one
 * immediate superior.
 *
 * Every soldier has to congratulate every other soldier. For a pair of soldiers if one of them is
 * the superior of the other, they will shake hands. Otherwise, they will bump their fists.
 *
 * You are given the list of immediate superior of all soldiers. Your job is to tell how many
 * handshakes and fist bumps will be there.
 *
 * NOTE: Among all soldiers there is one soldier who does not have any superior. He is the commander
 * of the whole army.
 *
 * Input:
 *
 * The first line of the input contains t, the number of test cases.
 *
 * The first line of each test case contains n, the number of soldiers. The next line contains n
 * space separated integers. The ith integer represents the immediate superior of the ith soldier.
 *
 * The immediate superior of the commander of the army will be '0'.
 *
 * Output:
 *
 * Output two space separated integers, the number of handshakes and the number of fist bumps.
 *
 * Constraints:
 *
 * 1<=t<=10
 *
 * 1<=n<=100000
 *
 * It is guaranteed that the commander of the army is a superior of all soldiers.
 *
 * SAMPLE INPUT 2 3 0 1 1 2 2 0 SAMPLE OUTPUT 2 1 1 0 Explanation 1st test case: Handshakes between
 * (1,2), (1,3). Fist bumps between (2,3)
 *
 * 2nd test case: Handshake between (1,2) No fist bumps
 */
public class TestClass {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
	array[i] = in.nextInt();
      }
      Army army = new Army(n, array);
      System.out.println(String.format("%s %s", army.getHandShakes(), army.getBumps()));
    }

    in.close();
  }

  private static class Army {
    private int noOfSoldiers;
    private int root;
    private List<Integer>[] children;
    private long handshakes;
    private long bumps;

    Army(int noOfSoldiers, int[] superiors) {
      this.noOfSoldiers = noOfSoldiers;
      this.children = (List<Integer>[]) new List[noOfSoldiers];
      for (int i = 0; i < noOfSoldiers; i++) {
	children[i] = new ArrayList<>();
      }
      for (int i = 0; i < noOfSoldiers; i++) {
	if (superiors[i] != 0) {
	  children[superiors[i] - 1].add(i);
	} else {
	  root = i;
	}
      }
      initSuperiorsCount();
    }

    private void initSuperiorsCount() {
      this.handshakes = 0;
      Deque<Integer> queue = new LinkedList<>();
      queue.add(root);
      int level = 0;
      while (!queue.isEmpty()) {
	int levelSize = queue.size();
	for (int i = 0; i < levelSize; i++) {
	  (children[queue.pollFirst()]).forEach(queue::addLast);
	}
	this.handshakes += levelSize * level;
	level++;
      }
      this.bumps = (long)(noOfSoldiers) * (long)(noOfSoldiers - 1) / 2 - handshakes;
    }

    private long getHandShakes() {
      return handshakes;
    }

    private long getBumps() {
      return bumps;
    }
  }
}
