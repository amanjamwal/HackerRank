package com.saambh.contest.random;

import java.util.Scanner;

/**
 * @author ajamwal
 * @since 9/19/17
 *
 *
 *
 *
 * A numeric string, , is beautiful if it can be split into a sequence of two or more positive integers, , satisfying the following conditions:
 * for any  (i.e., each element in the sequence is  more than the previous element).
 * No  contains a leading zero. For example, we can split  into the sequence , but it is not beautiful because  and  have leading zeroes.
 * The contents of the sequence cannot be rearranged. For example, we can split  into the sequence , but it is not beautiful because it breaks our first constraint (i.e., ).
 * The diagram below depicts some beautiful strings:
 * image
 * You must perform  queries, where each query consists of some string . For each query, print whether or not the string is beautiful on a new line. If it's beautiful, print YES x, where  is the first number of the increasing sequence (if there are multiple such values of , choose the smallest); otherwise, print NO instead.
 * Input FormatThe first line contains an integer denoting  (the number of strings to evaluate).
 * Each of the  subsequent lines contains some string  for a query.
 *
 * Constraints
 *
 * Each character in  is a decimal digit from  to  (inclusive).
 *
 * Output Format
 *
 * For each query, print its answer on a new line (i.e., either YES x where  is the smallest first number of the increasing sequence, or NO).
 *
 * Sample Input 0
 * 7
 * 1234
 * 91011
 * 99100
 * 101103
 * 010203
 * 13
 * 1
 *
 * Sample Output 0
 *
 * YES 1
 * YES 9
 * YES 99
 * NO
 * NO
 * NO
 * NO
 */

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      boolean isMagic = false;
      Long magicStart = 0l;
      for (int i = 1; i <= s.length()/2; i++) {
        String subString = s.substring(0, i);
        if (subString.startsWith("0")) {
          continue;
        }

        Long number = Long.parseLong(subString);
        String nayaString = subString;
        for(int j =1;nayaString.length() < s.length();j++) {
          nayaString = nayaString.concat(Long.toString(number + j));
        }
        if (s.equals(nayaString)) {
          isMagic = true;
          magicStart = number;
          break;
        }
      }
      System.out.println(isMagic ? "YES " + magicStart : "NO");
    }
  }
}
