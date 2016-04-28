package com.saambh.larry;

public class CustomList {
  private int[] array;
  private int[] indexArray;
  private int n;

  public CustomList(int n) {
    this.n = n;
    this.array = new int[n + 1];
    this.indexArray = new int[n + 1];
  }

  public void setValueInArray(int index, int value) {
    this.array[index] = value;
    this.indexArray[value] = index;
  }

  public boolean canFullySort() {
    for (int i = 1; i < n - 1; i++) {
      moveToCorrectPositionUsingRobotMove(indexArray[i]);
    }
    return array[n] == n;
  }

  private void moveToCorrectPositionUsingRobotMove(int curr) {
    int position = array[curr];
    if (position == curr) {
      return;
    }
    int start = curr - 2 > position ? curr - 2 : position;
    doRobotMove(start, curr);
    moveToCorrectPositionUsingRobotMove(start);
  }

  private void doRobotMove(int start, int curr) {
    int diff = curr - start;
    if (diff == 0) {
      return;
    } else if (diff == 1) {
      int temp = array[start];
      setValueInArray(start, array[curr]);
      setValueInArray(curr, array[start + 2]);
      setValueInArray(start + 2, temp);
    } else {
      int temp = array[start];
      setValueInArray(start, array[curr]);
      setValueInArray(curr, array[curr - 1]);
      setValueInArray(curr - 1, temp);
    }
  }
}
