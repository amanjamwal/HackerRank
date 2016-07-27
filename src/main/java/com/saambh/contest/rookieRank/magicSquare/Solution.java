package com.saambh.contest.rookieRank.magicSquare;

import java.util.Scanner;

/**
 * Created by aman.jamwal on 26/07/16. Consider a  matrix, , of integers in the inclusive range .
 * Any digit, , can be changed to any other digit, , in the range  at cost .
 *
 * Given matrix , convert it into a magic square by changing zero, one, or more of the digits in .
 * You must do this in such a way that the cost is minimal and then print the minimum possible cost
 * on a new line.
 *
 * Note: The resulting magic square must contain distinct integers in the inclusive range .
 *
 * Input Format
 *
 * There are  lines of input. Each line describes a row of the matrix in the form of
 * space-separated integers denoting the respective first, second, and third elements of that row.
 *
 * Constraints
 *
 * All integers in  are in the inclusive range . Output Format
 *
 * Print a single integer denoting the smallest possible cost of turning matrix  into a magic
 * square.
 *
 * Sample Input
 *
 * 4 9 2 3 5 7 8 1 5 Sample Output
 *
 * 1 Explanation
 *
 * Matrix  initially looks like this:
 *
 * 4 9 2 3 5 7 8 1 5 Observe that it's not yet magic, because not all rows, columns, and center
 * diagonals sum to the same number.
 *
 * If we change the bottom right value, , from  to  at a cost of ,  will become a magic square at
 * the minimum possible cost. Thus, we print the cost, , on a new line.
 */
public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] numbers = new int[3][3];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
	numbers[i][j] = in.nextInt();
      }
    }

    int[][] frame1 =
	{{4, 9, 2},
	 {3, 5, 7},
	 {8, 1, 6}};

    int[][] frame11 =
	{{8, 1, 6},
	 {3, 5, 7},
	 {4, 9, 2}};

    int[][] frame2 =
	{{8, 3, 4},
	 {1, 5, 9},
	 {6, 7, 2}};

    int[][] frame12 =
	{{4, 3, 8},
	 {9, 5, 1},
	 {2, 7, 6}};

    int[][] frame3 =
	{{6, 1, 8},
	 {7, 5, 3},
	 {2, 9, 4}};

    int[][] frame13 =
	{{2, 9, 4},
	 {7, 5, 3},
	 {6, 1, 8}};

    int[][] frame4 =
	{{2, 7, 6},
	 {9, 5, 1},
	 {4, 3, 8}};

    int[][] frame14 =
	{{6, 7, 2},
	 {1, 5, 9},
	 {8, 3, 4}};

    int cost1 = diff(numbers, frame1);
    int cost2 = diff(numbers, frame2);
    int cost3 = diff(numbers, frame3);
    int cost4 = diff(numbers, frame4);

    int cost11 = diff(numbers, frame11);
    int cost12 = diff(numbers, frame12);
    int cost13 = diff(numbers, frame13);
    int cost14 = diff(numbers, frame14);

    int min = Math.min(cost1, Math.min(cost2, Math.min(cost3, cost4)));
    int min1 = Math.min(cost11, Math.min(cost12, Math.min(cost13, cost14)));
    System.out.println(Math.min(min,min1));
    in.close();
  }

  private static int diff(int[][] numbers, int[][] frame) {
    int cost = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
	cost += Math.abs(numbers[i][j] - frame[i][j]);
      }
    }
    return cost;
  }
}