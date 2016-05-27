package com.saambh.PlayArea;

public class LinkedList<T> {
  private Node<T> head;
  private Node<T> tail;

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  public String print() {
    Node node = this.head;
    StringBuilder sb = new StringBuilder();
    while (node != null) {
      sb.append(node.item);
      node = node.next;
    }
    return sb.reverse().toString();
  }

  private static class Node<T> {
    private T item;
    private Node<T> next;

    public Node(T item) {
      this(item, null);
    }

    Node(T item, Node<T> next) {
      this.item = item;
      this.next = next;
    }
  }

  public void add(T item) {
    Node<T> node = new Node<>(item);
    if (tail == null) {
      this.head = this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
  }

  boolean isEmpty() {
    return this.head == null;
  }

  public T pop() {
    if (isEmpty()) {
      return null;
    }
    T item = this.head.item;
    this.head = this.head.next;
    if (this.head == null) {
      this.tail = null;
    }
    return item;
  }
}
