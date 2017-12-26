package Coursera;

import java.util.Scanner;

/**
 * @author ajamwal
 * @since 12/17/17
 */
public class LineSegment {
  private final Point p;
  private final Point q;

  // constructs the line segment between points p and q
  public LineSegment(Point p, Point q) {
    this.p = p;
    this.q = q;
  }

  // draws this line segment
  public void draw() {
  }

  // string representation
  public String toString() {
    return String.format("%s -> %s", p.toString(), q.toString());
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Point[] points = new Point[n];
    for (int i=0;i<n;i++){
      int x = in.nextInt();
      int y = in.nextInt();
      points[i] = new Point(x,y);
    }
    FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);
    for (LineSegment segment : fastCollinearPoints.segments()) {
      System.out.println(segment);
    }
    in.close();
  }
}
