package com.saambh.ds.trie.contacts;

import java.util.Scanner;

/**
 * Created by aman.jamwal on 05/07/16.
 *
 * We are going to make our own contacts application. You are given the number of operations to
 * perform, N. In any contacts application, two basic operations are add and find. The input will be
 * one of the following: add name find partial For the find operation, you will have to print the
 * number of contacts who have a name starting with that partial name.
 *
 * Input Format The first line contains the integer N, the number of operations to be performed. The
 * next N lines contains one of the two operations defined above.
 *
 * Constraints 1 <= N <= 10^5 1 <= Length(name) <= 21 1 <= Length(partial) <= 21
 *
 * The entire input consists of lowercase characters only.
 *
 * Output Format For each operation of type find partial, print the number of contacts starting with
 * the string partial.
 *
 * Sample Input 4 add hack add hackerrank find hac find hak
 *
 * Sample Output 2 0
 */

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    PrefixTree prefixTree = new PrefixTree();
    while (n-- > 0) {
      String type = in.next();
      if (type.equals("add")) {
	prefixTree.add(in.next());
      } else if (type.equals("find")) {
	System.out.println(prefixTree.find(in.next()));
      }
    }
    in.close();
  }
}
