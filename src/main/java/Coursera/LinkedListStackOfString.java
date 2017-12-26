package Coursera;

/**
 * @author ajamwal
 * @since 12/3/17
 */
public class LinkedListStackOfString extends StackOfString {

  private Node top;

  private class Node {
    String item;
    Node next;
  }

  public LinkedListStackOfString() {
    top = null;
  }

  @Override
  public void push(String item) {
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = top;
    top = newNode;
  }

  @Override
  public String pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty. Cannot pop from an empty stack");
    }
    String item = top.item;
    top = top.next;
    return item;
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }
}
