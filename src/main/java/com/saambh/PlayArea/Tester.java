package com.saambh.PlayArea;

import java.util.Scanner;

public class Tester {

  private static LinkedList<Integer> addNumbers(LinkedList<Integer> firstNumber,
                                                LinkedList<Integer> secondNumber) {

    LinkedList<Integer> sum = new LinkedList<>();

    int c = 0;
    while (!firstNumber.isEmpty() || !secondNumber.isEmpty() || c != 0) {
      int f = 0;
      if (!firstNumber.isEmpty()) {
        f = firstNumber.pop();
      }

      int s = 0;
      if (!secondNumber.isEmpty()) {
        s = secondNumber.pop();
      }

      int localSum = c + f + s;
      sum.add(localSum % 10);
      c = localSum / 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    LinkedList<Integer> f = transform(in.nextInt());
    LinkedList<Integer> s = transform(in.nextInt());
    LinkedList<Integer> sum = addNumbers(f, s);
    System.out.println(sum.print());
  }

  private static LinkedList<Integer> transform(Integer number) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    while (number > 0) {
      linkedList.add(number % 10);
      number /= 10;
    }
    return linkedList;
  }
}
