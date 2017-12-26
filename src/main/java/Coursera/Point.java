package Coursera;

import java.util.Comparator;

/**
 * @author ajamwal
 * @since 12/17/17
 */
public class Point implements Comparable<Point> {
  private final int x;
  private final int y;

  // constructs the point (x, y)
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // draws this point
  public void draw() {

  }

  // draws the line segment from this point to that point
  public void drawTo(Point that) {

  }

  // string representation
  public String toString() {
    return String.format("(%d,%d)", x, y);
  }

  // compare two points by y-coordinates, breaking ties by x-coordinates
  public int compareTo(Point that) {
    if (this.y < that.y || (this.y == that.y && this.x < that.x)) {
      return -1;
    } else if (this.y > that.y || (this.y == that.y && this.x > that.x)) {
      return 1;
    }
    return 0;
  }

  // the slope between this point and that point
  public double slopeTo(Point that) {
    if (that.x == this.x && that.y == this.y) {
      return Double.NEGATIVE_INFINITY;
    } else if (that.x == this.x) {
      return Double.POSITIVE_INFINITY;
    } else if (that.y == this.y) {
      return 0.0;
    }
    return (double) (that.y - this.y) / (that.x - this.x);
  }

  // compare two points by slopes they make with this point
  public Comparator<Point> slopeOrder() {
    return (first, second) -> {
      double slopeToFirst = slopeTo(first);
      double slopeToSecond = slopeTo(second);
      if (slopeToFirst < slopeToSecond) {
        return -1;
      } else if (slopeToFirst == slopeToSecond) {
        return 0;
      }
      return 1;
    };
  }
}