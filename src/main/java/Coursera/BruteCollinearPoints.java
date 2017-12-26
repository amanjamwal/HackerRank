package Coursera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ajamwal
 * @since 12/17/17
 */
public class BruteCollinearPoints {
  private final Point[] points;

  private List<LineSegment> lineSegments;

  // finds all line segments containing 4 points
  public BruteCollinearPoints(Point[] points) {
    if (points == null || hasNullOrDuplicate(points)) {
      throw new IllegalArgumentException("Empty or duplicate points");
    }
    Arrays.sort(points);
    this.points = points.clone();
    this.lineSegments = new ArrayList<>();

    preProcess();
  }

  private void preProcess() {
    for (int p = 0; p < points.length; p++) {
      for (int q = p + 1; q < points.length; q++) {
        double slopePQ = points[p].slopeTo(points[q]);
        for (int r = q + 1; r < points.length; r++) {
          double slopePR = points[p].slopeTo(points[r]);
          if (slopePQ != slopePR) {
            continue;
          }
          for (int s = r + 1; s < points.length; s++) {
            if (slopePQ == points[p].slopeTo(points[s])) {
              lineSegments.add(new LineSegment(points[p], points[s]));
              break;
            }
          }
        }
      }
    }
  }

  private static boolean hasNullOrDuplicate(Point[] points) {
    if (points == null || points.length == 0) {
      return false;
    }

    Point[] pointsCopy = points.clone();
    for (Point point : pointsCopy) {
      if (point == null) {
        return true;
      }
    }

    Arrays.sort(pointsCopy);
    Point prev = null;
    for (Point point : pointsCopy) {
      if (prev != null && prev.slopeTo(point) == Double.NEGATIVE_INFINITY) {
        return true;
      }
      prev = point;
    }
    return false;
  }

  // the number of line segments
  public int numberOfSegments() {
    return lineSegments.size();
  }

  // the line segments
  public LineSegment[] segments() {
    return lineSegments.toArray(new LineSegment[lineSegments.size()]);
  }
}