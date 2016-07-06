package com.saambh.ds.trie.contacts;

public class PrefixTree {
  private Node root;

  public PrefixTree() {
    this.root = new Node();
  }

  public void add(String value) {
    String modifiedValue = value + "$";
    root.add(modifiedValue);
  }

  public int find(String next) {
    return root.find(next);
  }

  private static class Node {
    private int noOfLeaves;
    private Node[] lookUp;

    Node() {
      this.noOfLeaves = 0;
      this.lookUp = new Node[27];
    }

    public void add(String value) {
      if (value == null || value.isEmpty()) {
	return;
      }
      char c = value.charAt(0);
      int key = c != '$' ? c - 'a' + 1 : 0;
      if (lookUp[key] == null) {
	lookUp[key] = new Node();
      }
      lookUp[key].add(value.substring(1));
      noOfLeaves++;
    }

    public int find(String next) {
      if (next.isEmpty()) {
	return this.noOfLeaves;
      }

      char c = next.charAt(0);
      int key = c != '$' ? c - 'a' + 1 : 0;
      if (lookUp[key] != null) {
	return lookUp[key].find(next.substring(1));
      } else {
	return 0;
      }
    }
  }
}
