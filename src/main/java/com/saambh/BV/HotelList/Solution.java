package com.saambh.BV.HotelList;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String keyWordLine = in.nextLine();

    HotelReview hotelReview = new HotelReview(keyWordLine.split(" "));
    int t = in.nextInt();
    while (t-- > 0) {
      long hotelId = in.nextLong();
      in.nextLine();
      String review = in.nextLine();
      hotelReview.addReview(hotelId, review);
    }
    System.out.println(hotelReview.getSortedHotels());
  }
}
