package com.saambh.BV.polygons;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    UniverseOfPolygons universeOfPolygons = new UniverseOfPolygons();
    while (in.hasNextInt()) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      int d = in.nextInt();

      universeOfPolygons.addNewPolygon(a, b, c, d);
    }
    System.out.println(universeOfPolygons.getSquareCount() + " " +
                       universeOfPolygons.getRectangleCount() + " " +
                       universeOfPolygons.getOtherPolygonCount());
  }
}
