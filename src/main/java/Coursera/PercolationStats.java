package Coursera;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * @author ajamwal
 * @since 11/26/17
 */
public class PercolationStats {
  private static final double CONFIDENCE_95 = 1.96;
  private final int n;
  private final double[] runs;

  // perform trials independent experiments on an n-by-n grid
  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException("Either n or trials has invalid value");
    }
    this.n = n;
    this.runs = new double[trials];
    for (int i = 0; i < trials; i++) {
      Percolation percolation = new Percolation(n);
      while (!percolation.percolates()) {
        int row;
        int col;
        do {
          row = StdRandom.uniform(1, n + 1);
          col = StdRandom.uniform(1, n + 1);
        } while (percolation.isOpen(row, col));
        percolation.open(row, col);
      }
      runs[i] = (double) percolation.numberOfOpenSites() / (n * n);
    }
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(runs);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(runs);
  }

  // low  endpoint of 95% confidence interval
  public double confidenceLo() {
    return mean() - (CONFIDENCE_95 * stddev() / n);
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    return mean() + (CONFIDENCE_95 * stddev() / n);
  }

  // test client (described below)
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Expected two integer input parameters");
    } else {
      try {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, t);
        System.out.println(String.format("%-30s = %.15f", "mean", percolationStats.mean()));
        System.out.println(String.format("%-30s = %.15f", "stddev", percolationStats.stddev()));
        System.out.println(String.format("%-30s = [%.15f, %.15f]", "95 % confidence interval",
            percolationStats.confidenceLo(),
            percolationStats.confidenceHi())
        );

      } catch (NumberFormatException ex) {
        System.out.println("Expected two integer input parameters");
        throw ex;
      }
    }
  }
}