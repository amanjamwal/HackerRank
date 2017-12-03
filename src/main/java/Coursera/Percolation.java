package Coursera;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author ajamwal
 * @since 11/26/17
 */
public class Percolation {
  private final int n;
  private final WeightedQuickUnionUF uf;
  private final boolean[][] sites;
  private int numberOfOpenSites;

  private final int source;
  private final int destination;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    validate(n);

    this.n = n;
    this.uf = new WeightedQuickUnionUF(n * n + 2);
    this.source = 0;
    this.destination = n * n + 1;

    this.sites = new boolean[n][n];
    numberOfOpenSites = 0;
  }

  private void validate(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Grid should to be at least 1*1");
    }
  }

  private void validate(int row, int col) {
    if (row < 1 || row > n || col < 1 || col > n) {
      throw new IllegalArgumentException("Row or Column value is out of range");
    }
  }

  private void connectIfOpen(int pos, int row, int col) {
    if (row >= 1 && row <= n && col >= 1 && col <= n && isOpen(row, col)) {
      uf.union(n * (row - 1) + col, pos);
    }
  }

  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    validate(row, col);
    if (!isOpen(row, col)) {
      sites[row - 1][col - 1] = true;
      numberOfOpenSites++;
    }
    int pos = n * (row - 1) + col;

    if (row == 1) {
      uf.union(source, pos);
    } else if (row == n) {
      uf.union(pos, destination);
    }

    // Try with left
    connectIfOpen(pos, row, col - 1);

    // Try with top
    connectIfOpen(pos, row - 1, col);

    // Try with right
    connectIfOpen(pos, row, col + 1);

    // Try with bottom
    connectIfOpen(pos, row + 1, col);
  }

  // is site (row, col) open?
  public boolean isOpen(int row, int col) {
    validate(row, col);
    return sites[row - 1][col - 1];
  }

  // is site (row, col) full?
  public boolean isFull(int row, int col) {
    validate(row, col);
    return isOpen(row, col) && uf.connected(source, n * (row - 1) + col);
  }

  // number of open sites
  public int numberOfOpenSites() {
    return numberOfOpenSites;
  }

  // does the system percolate?
  public boolean percolates() {
    return uf.connected(source, destination);
  }

  public static void main(String[] args) {
    Percolation percolation = new Percolation(8);
    percolation.open(1, 3);
    percolation.open(1, 4);
    percolation.open(1, 5);
    percolation.open(2, 1);
    percolation.open(2, 4);
    percolation.open(2, 5);
    percolation.open(2, 6);
    percolation.open(2, 7);
    percolation.open(2, 8);
    percolation.open(3, 1);
    percolation.open(3, 2);
    percolation.open(3, 3);
    percolation.open(3, 6);
    percolation.open(3, 7);
    percolation.open(4, 3);
    percolation.open(4, 4);
    percolation.open(4, 6);
    percolation.open(4, 7);
    percolation.open(4, 8);
    percolation.open(5, 2);
    percolation.open(5, 3);
    percolation.open(5, 4);
    percolation.open(5, 6);
    percolation.open(5, 7);
    percolation.open(6, 2);
    percolation.open(6, 7);
    percolation.open(6, 8);
    percolation.open(7, 1);
    percolation.open(7, 3);
    percolation.open(7, 5);
    percolation.open(7, 6);
    percolation.open(7, 7);
    percolation.open(7, 8);
    percolation.open(8, 1);
    percolation.open(8, 2);
    percolation.open(8, 3);
    percolation.open(8, 4);
    percolation.open(8, 6);
    System.out.println(percolation.percolates() ? "Yes" : "No");
  }
}
