package Coursera;

/**
 * @author ajamwal
 * @since 12/3/17
 */
public class LinkedList<E> implements List<E> {
  private Node first;
  private Node last;

  public LinkedList() {
    first = last = null;
  }

  private class Node {
    E item;
    Node next;
  }

  @Override
  public void add(E item) {
    Node oldLast = last;

    last = new Node();
    last.item = item;
    last.next = null;

    if (oldLast != null) {
      oldLast.next = last;
    } else {
      first = last;
    }
  }

  @Override
  public E delete() {
    if (isEmpty()) {
      throw new RuntimeException("Empty list");
    }
    E item = first.item;
    first = first.next;
    if (first == null) {
      last = null;
    }
    return item;
  }

  private boolean isEmpty() {
    return first == null;
  }
}
