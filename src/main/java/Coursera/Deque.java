package Coursera;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author ajamwal
 * @since 12/9/17
 */

public class Deque<Item> implements Iterable<Item> {

  private Item[] items;
  private int capacity;
  private int size;
  private int first;
  private int last;

  public Deque() {
    this.capacity = 4;
    this.items = (Item[]) new Object[capacity];
    this.size = 0;
    this.first = -1;
    this.last = -1;
  }

  private void resize(int oldCapacity, int newCapacity) {
    Item[] oldItems = items;
    items = (Item[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      items[i] = oldItems[first];
      first = (first + 1) % oldCapacity;
    }
    first = 0;
    last = size - 1;
  }

  private void lazyExpand() {
    if (2 * size < capacity) {
      return;
    }
    resize(capacity, capacity * 2);
    capacity *= 2;
  }

  private void lazyShrink() {
    if (4 * size > capacity) {
      return;
    }
    resize(capacity, capacity / 2);
    capacity /= 2;
  }

  // is the deque empty?
  public boolean isEmpty() {
    return size == 0;
  }

  // return the number of items on the deque
  public int size() {
    return size;
  }

  // add the item to the front
  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Cannot add empty values");
    }

    if (first == -1) {
      first = 0;
      last = 0;
      items[first] = item;
    } else {
      lazyExpand();
      first = (first + capacity - 1) % capacity;
      items[first] = item;
    }
    size++;
  }

  // add the item to the end
  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Cannot add empty values");
    }

    if (first == -1) {
      first = 0;
      last = 0;
      items[first] = item;
    } else {
      lazyExpand();
      last = (last + 1) % capacity;
      items[last] = item;
    }
    size++;
  }

  // remove and return the item from the front
  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from an empty collection");
    }
    lazyShrink();
    Item item = items[first % capacity];
    items[first % capacity] = null;
    first = (first + 1) % capacity;
    size--;
    return item;
  }

  // remove and return the item from the end
  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from an empty collection");
    }
    lazyShrink();
    Item item = items[last % capacity];
    items[last % capacity] = null;
    last = (last + capacity - 1) % capacity;
    size--;
    return item;
  }

  // return an iterator over items in order from front to end
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
      private int current = first;

      @Override
      public boolean hasNext() {
        if (isEmpty()) {
          return false;
        }
        if (first < last) {
          return first <= current && current <= last;
        }
        return first <= current && current <= (last + capacity);
      }

      @Override
      public Item next() {
        if (!hasNext()) {
          throw new NoSuchElementException("No more elements to iterate");
        }
        Item item = items[current % capacity];
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
    Deque<String> stringDeque = new Deque<>();
    stringDeque.addFirst("Hello");
    stringDeque.addFirst("World");
    for (String s : stringDeque) {
      System.out.println(s);
    }
  }
}
