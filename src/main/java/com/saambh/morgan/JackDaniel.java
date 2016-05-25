package com.saambh.morgan;

public class JackDaniel {
  private char[] jackString;
  private char[] danielString;

  public JackDaniel(String jack, String daniel) {
    this.jackString = jack.toCharArray();
    this.danielString = daniel.toCharArray();
  }

  public String morganString() {
    StringBuilder sb = new StringBuilder(jackString.length + danielString.length);
    morganString(sb, 0, 0);
    return sb.toString();
  }

  private void morganString(StringBuilder sb, int j, int d) {
    if (j < jackString.length && d < danielString.length) {
      if (jackString[j] < danielString[d]) {
        sb.append(jackString[j]);
        j++;
      } else if (jackString[j] > danielString[d]) {
        sb.append(danielString[d]);
        d++;
      } else {
        if (isJackFirst(j + 1, d + 1)) {
          sb.append(jackString[j]);
          j++;
        } else {
          sb.append(danielString[d]);
          d++;
        }
      }
    } else if (j < jackString.length) {
      sb.append(jackString[j]);
      j++;
    } else if (d < danielString.length) {
      sb.append(danielString[d]);
      d++;
    } else {
      return;
    }
    morganString(sb, j, d);
  }

  private boolean isJackFirst(int j, int d) {
    if (j == jackString.length) {
      return false;
    }

    if (d == danielString.length) {
      return true;
    }

    if (jackString[j] < danielString[d]) {
      return true;
    } else if (jackString[j] > danielString[d]) {
      return false;
    }
    return isJackFirst(j + 1, d + 1);
  }
}
