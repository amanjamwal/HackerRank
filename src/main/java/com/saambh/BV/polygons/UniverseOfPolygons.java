package com.saambh.BV.polygons;

public class UniverseOfPolygons {
  private int squareCount;
  private int rectangleCount;
  private int otherPolygonCount;

  public UniverseOfPolygons() {
    this.squareCount = 0;
    this.rectangleCount = 0;
    this.otherPolygonCount = 0;
  }

  public void addNewPolygon(int a, int b, int c, int d) {
    if (a <= 0 || b <= 0 || c <= 0 | d <= 0) {
      this.otherPolygonCount++;
      return;
    }

    if (a == c && b == d) {
      if (a == b) {
        this.squareCount++;
      } else {
        this.rectangleCount++;
      }
    } else {
      this.otherPolygonCount++;
    }
  }

  public int getSquareCount() {
    return squareCount;
  }

  public int getRectangleCount() {
    return rectangleCount;
  }

  public int getOtherPolygonCount() {
    return otherPolygonCount;
  }
}
