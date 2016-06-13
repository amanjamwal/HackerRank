package com.saambh.snackdown.ENTEXAM;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int N = sc.nextInt();
      int K = sc.nextInt();
      int E = sc.nextInt();
      int M = sc.nextInt();
      EntranceExam entranceExam = new EntranceExam(K, M);

      for (int i = 0; i < N - 1; i++) {
	long score = 0;
	for (int j = 0; j < E; j++) {
	  score += sc.nextLong();
	}
	entranceExam.addTotalScore(score);
      }

      long score = 0;
      for (int j = 0; j < E - 1; j++) {
	score += sc.nextLong();
      }
      long req = entranceExam.minRequiredForK(score);

      System.out.println(req >= 0 ? req : "Impossible");
    }
    sc.close();
  }
}

class EntranceExam {
  private int M;

  MinHeap minHeap;

  public EntranceExam(int K, int M) {
    this.M = M;
    this.minHeap = new MinHeap(K);
  }

  public void addTotalScore(long score) {
    this.minHeap.add(score);
  }

  public long minRequiredForK(long scoreTillNow) {
    long minOfMaxScore = minHeap.min();
    long diff = minOfMaxScore + 1 - scoreTillNow;

    if (diff <= 0) {
      return 0;
    } else if (diff <= M) {
      return diff;
    } else {
      return -1;
    }
  }
}

class MinHeap {
  private long[] data;
  private int size;

  public MinHeap(int size) {
    this.data = new long[size + 1];
    this.size = 0;
  }

  public void add(long value) {
    if (isFull() && value > data[1]) {
      data[1] = value;
      heapifyDown(1);
    } else if (!isFull()) {
      data[++size] = value;
      heapifyUp(size);
    }
  }

  private void heapifyUp(int index) {
    if (index / 2 == 0 || data[index] > data[index / 2]) {
      return;
    }
    swap(index, index / 2);
    heapifyUp(index / 2);
  }

  private void heapifyDown(int index) {
    int minIndex;
    if (index * 2 < data.length && index * 2 + 1 < data.length) {
      if (data[index * 2] < data[index * 2 + 1]) {
	minIndex = index * 2;
      } else {
	minIndex = index * 2 + 1;
      }
    } else if (index * 2 < data.length) {
      minIndex = index * 2;
    } else if (index * 2 + 1 < data.length) {
      minIndex = index * 2 + 1;
    } else {
      return;
    }
    if (data[index] > data[minIndex]) {
      swap(index, minIndex);
      heapifyDown(minIndex);
    }
  }

  private void swap(int index, int minIndex) {
    data[index] ^= data[minIndex];
    data[minIndex] ^= data[index];
    data[index] ^= data[minIndex];
  }

  private boolean isFull() {
    return size + 1 == data.length;
  }

  public long min() {
    if (isEmpty()) {
      return 0;
    }
    return data[1];
  }

  private boolean isEmpty() {
    return this.size == 0;
  }
}