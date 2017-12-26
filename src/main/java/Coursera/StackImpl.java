package Coursera;

/**
 * @author ajamwal
 * @since 12/3/17
 */
public class StackImpl<E> implements Stack<E> {
  private Node top;

  private class Node {
    E item;
    Node next;
  }

  public StackImpl() {
    top = null;
  }

  @Override
  public void push(E item) {
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = top;
    top = newNode;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty. Cannot pop from an empty stack");
    }
    E item = top.item;
    top = top.next;
    return item;
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }
}
