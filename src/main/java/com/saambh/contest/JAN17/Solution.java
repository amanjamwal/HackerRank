package com.saambh.contest.JAN17;

import java.util.Scanner;

/**
 * Chef is a farmer and a pet lover. He has a lot of his favorite pets cats and dogs in the barn. He does not know their exact count. But he knows that there are C cats and D dogs in the barn. Also, one day went to field and found that there were L legs of the animals touching the ground. Chef knows that cats love to ride on the dogs. So, they might ride on the dogs, and their legs won't touch the ground and Chef would miss counting their legs. Chef's dogs are strong enough to ride at max two cats on their back.
 * It was a cold foggy morning, when Chef did this counting. So he is now wondering whether he counted the legs properly or not. Specifically, he is wondering is there a some possibility of his counting being correct. Please help Chef in finding it.
 *
 * Input
 *
 * First line of the input contains an integer T denoting number of test cases. T test cases follow.
 *
 * The only line of each test case contains three space separated integers C, D, L denoting number of the cats, number of the dogs and number of legs of animals counted by Chef, respectively.
 *
 * Output
 *
 * For each test case, output a single line containing a string "yes" or "no" (both without quotes) according to the situation.
 *
 * Constraints
 * 1 ≤ T ≤ 105
 * 0 ≤ C, D, L ≤ 109
 *
 * Subtasks
 *
 * Subtask #1 (20 points)
 * 1 ≤ T ≤ 104
 * 0 ≤ C, D ≤ 102
 *
 * Subtask #2 (30 points)
 * 1 ≤ T ≤ 105
 * 0 ≤ C, D ≤ 103
 *
 * Subtask #3 (50 points)
 *
 * Original constraints
 * Example
 *
 * Input:
 * 3
 * 1 1 8
 * 1 1 4
 * 1 1 2
 *
 * Output:
 * yes
 * yes
 * no
 */

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {

      int c = in.nextInt();
      int d = in.nextInt();
      int l = in.nextInt();

      boolean possible = false;
      if (l >= 4 * d
          && l <= 4 * (d + c)
          && (l - 4 * d) % 4 == 0
          && (l - 4 * d) / 4 >= (c - 2 * d)
          && (l - 4 * d) / 4 <= c) {

        possible = true;
      }

      System.out.println(possible ? "yes" : "no");
    }
    in.close();
  }
}