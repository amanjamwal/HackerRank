package Coursera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ajamwal
 * @since 12/17/17
 */
public class FastCollinearPoints {
  private final Point[] points;

  private List<LineSegment> lineSegments;

  // finds all line segments containing 4 or more points
  public FastCollinearPoints(Point[] points) {
    if (points == null || hasNullOrDuplicate(points)) {
      throw new IllegalArgumentException("Empty or duplicate points");
    }

    this.points = points.clone();
    this.lineSegments = new ArrayList<>();

    preProcess();
  }

  private void preProcess() {
    for (int p = 0; p < points.length; p++) {

      Point[] localPoints = new Point[points.length - 1];
      for (int q = 0, i = 0; q < points.length; q++) {
        if (p == q) {
          continue;
        }
        localPoints[i++] = points[q];
      }
      Arrays.sort(localPoints, points[p].slopeOrder());
      for (int i = 0; i < localPoints.length; ) {
        int collinearPoints = 0;
        Point min = localPoints[i].compareTo(points[p]) < 0 ? localPoints[i] : points[p];
        Point max = localPoints[i].compareTo(points[p]) > 0 ? localPoints[i] : points[p];
        double slopePQ = points[p].slopeTo(localPoints[i++]);
        collinearPoints++;
        while (i < localPoints.length && slopePQ == points[p].slopeTo(localPoints[i])) {
          if (localPoints[i].compareTo(min) < 0) {
            min = localPoints[i];
          } else if (localPoints[i].compareTo(max) > 0) {
            max = localPoints[i];
          }
          i++;
          collinearPoints++;
        }

        if (collinearPoints >= 3) {
          LineSegment newLineSegment = new LineSegment(min, max);
          if (!isPresent(lineSegments, newLineSegment)) {
            lineSegments.add(newLineSegment);
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

  private static boolean isPresent(List<LineSegment> lineSegments, LineSegment lineSegment) {
    for (LineSegment subject : lineSegments) {
      if (lineSegment.toString().equals(subject.toString())) {
        return true;
      }
    }
    return false;
  }

}