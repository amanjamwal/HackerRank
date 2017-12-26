package Coursera;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author ajamwal
 * @since 12/10/17
 */

public class RandomizedQueue<Item> implements Iterable<Item> {

  private Node first;
  private Node last;
  private int size;

  private class Node {
    Item item;
    Node next;
    Node prev;
  }

  public RandomizedQueue() {
    this.size = 0;
    this.first = null;
    this.last = null;
  }

  // is the randomized queue empty?
  public boolean isEmpty() {
    return size == 0;
  }

  // return the number of items on the randomized queue
  public int size() {
    return size;
  }

  // add the item
  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Cannot add empty values");
    }
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = null;

    if (first == null) {
      first = newNode;
    } else {
      last.next = newNode;
    }
    newNode.prev = last;
    last = newNode;

    size++;
  }

  // remove and return a random item
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from an empty collection");
    }

    int randomIndex = StdRandom.uniform(0, size);
    Node runner = first;
    while (randomIndex-- > 0) {
      runner = runner.next;
    }
    Item item = runner.item;

    if (first == runner) {
      first = runner.next;
    } else if (last == runner) {
      last = runner.prev;
    } else {
      runner.prev = runner.next;
    }

    size--;
    return item;
  }

  // return a random item (but do not remove it)
  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from an empty collection");
    }
    int randomIndex = StdRandom.uniform(0, size);
    Node runner = first;
    while (randomIndex-- > 0) {
      runner = runner.next;
    }
    return runner.item;
  }

  // return an independent iterator over items in random order
  public Iterator<Item> iterator() {
    Item[] items = (Item[]) new Object[size];
    Node runner = first;
    for (int i = 0; i < size; i++) {
      items[i] = runner.item;
      runner = runner.next;
    }
    StdRandom.shuffle(items, 0, size);
    return new Iterator<Item>() {
      Item[] randomizedItems = items.clone();
      private int current = 0;
      private int first = 0;
      private int last = size - 1;

      @Override
      public boolean hasNext() {
        return first <= current && current <= last;
      }

      @Override
      public Item next() {
        if (!hasNext()) {
          throw new NoSuchElementException("No more elements to iterate");
        }
        Item item = randomizedItems[current];
        current = current + 1;
        return item;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException("Not supported in this implementation");
      }
    };
  }

  // unit testing (optional)
  public static void main(String[] args) {
    RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
    System.out.println(rq.size());
    rq.enqueue(746);
    System.out.println(rq.sample());
    System.out.println(rq.dequeue());

  }
}