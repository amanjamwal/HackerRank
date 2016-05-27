package com.saambh.account;

public class Wallet {
  private static final int INFINITY = Integer.MAX_VALUE - 1;
  private int[] coins;
  private int noOfCoins;

  public Wallet(int noOfCoins, int[] coins) {
    this.noOfCoins = noOfCoins;
    this.coins = coins;
  }

  public long noOfWays(int n) {
    long[][] wayCount = new long[noOfCoins][n + 1];

    for (int i = 0; i < noOfCoins; i++) {
      wayCount[i][0] = 1L;
    }

    for (int j = coins[0]; j <= n; j++) {
      wayCount[0][j] = j % coins[0] == 0 ? 1L : 0L;
    }

    for (int i = 1; i < noOfCoins; i++) {
      for (int j = 1; j <= n && j < coins[i]; j++) {
        wayCount[i][j] = wayCount[i - 1][j];
      }
      for (int j = coins[i]; j <= n; j++) {
        wayCount[i][j] = wayCount[i - 1][j] + wayCount[i][j - coins[i]];
      }
    }

    return wayCount[noOfCoins - 1][n];
  }

  public int minCoins(int n) {
    int[] minCount = new int[n + 1];
    minCount[0] = 0;

    for (int i = 1; i <= n; i++) {
      minCount[i] = INFINITY;
      for (int j = 0; j < noOfCoins && coins[j] <= i; j++) {
        int currentCount = minCount[i - coins[j]] + 1;
        minCount[i] = minCount[i] > currentCount ? currentCount : minCount[i];
      }
    }
    return minCount[n];
  }
}
