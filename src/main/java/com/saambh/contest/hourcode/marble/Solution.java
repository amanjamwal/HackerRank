package com.saambh.contest.hourcode.marble;

import java.util.Scanner;

/**
 * Jill and Bob are playing the following game:
 *
 * There are  cups on saucers arranged in a straight line. Each saucer is numbered sequentially from  to .
 * The game starts when Jill watches Bob place a marble inside the cup on saucer number .
 * Bob then takes  turns. In each turn, he swaps the cups on a pair of saucers numbered  and , where . The diagram below shows an example:
 * image
 *
 * After Bob completes all his turns, Jill chooses an integer from  to  denoting the saucer where she think the cup with the marble is located.
 * Given  and Bob's sequence of moves, print the saucer number denoting the marble's location at the end of the game.
 *
 * Input Format
 * The first line contains two space-separated integers describing the respective values of  (the marble's initial location) and  (Bob's number of turns).
 * Each line  of the  subsequent lines contains two space-separated integers,  and , describing the saucer numbers for the cups Bob swaps in his  move.
 *
 * Constraints
 *
 * Output Format
 *
 * Print an integer denoting the saucer number of the cup containing the marble at the end of the game.
 *
 * Sample Input 0
 * 5 3
 * 2 5
 * 7 10
 * 2 9
 *
 * Sample Output 0
 * 9
 */

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    while(n-- > 0){
      int pos1 = in.nextInt();
      int pos2 = in.nextInt();
      if(pos1 == m) {
        m = pos2;
      } else if( pos2 == m) {
        m = pos1;
      }
    }
    System.out.println(m);
    in.close();
  }
}