package Coursera;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author ajamwal
 * @since 12/10/17
 */
public class Permutation {
  public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);
    RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
    while (!StdIn.isEmpty()) {
      String str = StdIn.readString();
      randomizedQueue.enqueue(str);
    }
    Iterator<String> iterator = randomizedQueue.iterator();
    for (int i = 0; i < k; i++) {
      System.out.println(iterator.next());
    }
  }
}