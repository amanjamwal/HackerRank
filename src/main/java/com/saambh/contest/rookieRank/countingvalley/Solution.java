package com.saambh.contest.rookieRank.countingvalley;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by aman.jamwal on 26/07/16.
 *
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details
 * like topography. During his last hike, he took exactly steps. For every step he took, he noted if
 * it was an uphill or a downhill step. Gary's hikes start and end at sea level. We define the
 * following terms:
 *
 * A mountain is a non-empty sequence of consecutive steps above sea level, starting with a step up
 * from sea level and ending with a step down to sea level.
 *
 * A valley is a non-empty sequence of consecutive steps below sea level, starting with a step down
 * from sea level and ending with a step up to sea level.
 *
 * Given Gary's sequence of up and down steps during his last hike, find and print the number of
 * valleys he walked through.
 *
 * Input Format
 *
 * The first line contains an integer, n, denoting the number of steps in Gary's hike. The second
 * line contains a single string of n characters. Each character belongs to {U,D} (where U indicates
 * a step up and D indicates a step down), and the ith character in the string describes Gary's ith
 * step during the hike.
 *
 * Constraints
 *
 * 2<= N<=10^6
 *
 * Output Format
 *
 * Print a single integer denoting the number of valleys Gary walked through during his hike.
 *
 * Sample Input
 *
 * 8 UDDDUDUU
 *
 * Sample Output
 *
 * 1
 */
public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Deque<Character> charList = new LinkedList<>();
    String s = in.next();
    int valleyCount = 0;
    for (char c : s.toCharArray()) {
      if (!charList.isEmpty()) {
	char p = charList.peek();
	if (c == p) {
	  charList.push(c);
	} else {
	  charList.pop();
	  if (charList.isEmpty() && c == 'U') {
	    valleyCount++;
	  }
	}
      } else {
	charList.push(c);
      }
    }
    System.out.println(valleyCount);
    in.close();
  }
}