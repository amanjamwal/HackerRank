package com.saambh.fib;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
  private static BigInteger fibonacciModified(int a, int b, int n) {
    BigInteger[] fibs = new BigInteger[n];
    fibs[0] = BigInteger.valueOf(a);
    fibs[1] = BigInteger.valueOf(b);
    for(int i=2; i < n ;i++){
      fibs[i] = fibs[i-1].multiply(fibs[i-1]).add(fibs[i-2]);
    }
    return fibs[n-1];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int b = in.nextInt();
    int n = in.nextInt();
    System.out.println(fibonacciModified(a, b, n));
  }
}