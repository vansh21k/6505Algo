package com.vanshk.dynamicprogramming;

// min transformations from strA -> StrB using DP
public class EditDistance {
  public static int editDistance(String x, String y) {
    char[] xArr = x.toCharArray();
    char[] yArr = y.toCharArray();
    int n = xArr.length;
    int m = yArr.length;
    return editDistanceHelper(xArr, yArr, n, m);
  }

  private static int editDistanceHelper(char[] xArr, char[] yArr, int n, int m) {
    int[][] editDistanceGrid = new int[n + 1][m + 1];
    for (int i = 0; i < editDistanceGrid.length; ++i) {
      for (int j = 0; j < editDistanceGrid[0].length; ++j) {
        if (i == 0) {
          editDistanceGrid[i][j] = j;
        } else if (j == 0) {
          editDistanceGrid[i][j] = i;
        } else if (xArr[i - 1] == yArr[j - 1]) {
          editDistanceGrid[i][j] = editDistanceGrid[i - 1][j - 1];
        } else {
          // we have given uniform weights for insertion, deletion and
          // mismatch in this example
          editDistanceGrid[i][j] =
              Math.min(Math.min(editDistanceGrid[i - 1][j], editDistanceGrid[i][j - 1]),
                  editDistanceGrid[i - 1][j - 1]) + 1;
        }
      }
    }
    return editDistanceGrid[n][m];
  }

  public static void main(String[] args) {
    String one = "vansh";
    String two = "ananya";
    System.out.println(editDistance(one, two));
    System.out.println(editDistance("saturday", "sunday"));
  }
}
