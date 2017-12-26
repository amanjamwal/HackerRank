package Coursera;

/**
 * @author ajamwal
 * @since 12/3/17
 */
public interface Stack<E> {
  void push(E item);

  E pop();

  boolean isEmpty();
}
