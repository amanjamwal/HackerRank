package com.saambh.ds.trie.noPrefixSet;

public class PrefixTree {
  private Node root;
  private String firstBadString;

  public PrefixTree() {
    this.root = new Node();
    this.firstBadString = null;
  }

  public void add(String value) {
    String modifiedValue = value + "$";
    if (root.add(modifiedValue) && firstBadString == null) {
      firstBadString = value;
    }
  }

  public String badSetString() {
    return firstBadString;
  }

  private static class Node {
    private Node[] lookUp;
    private boolean hasOne;

    Node() {
      this.lookUp = new Node[11];
      this.hasOne = false;
    }

    public boolean add(String value) {
      if (value == null || value.isEmpty()) {
	return false;
      }
      boolean addResult = false;
      char c = value.charAt(0);
      int key = c != '$' ? c - 'a' + 1 : 0;

      if (key == 0) {
	addResult = hasOne;
      } else if (lookUp[0] != null) {
	addResult = true;
      }

      if (lookUp[key] == null) {
	lookUp[key] = new Node();
      }
      addResult = lookUp[key].add(value.substring(1)) || addResult;
      hasOne = true;
      return addResult;
    }
  }
}
