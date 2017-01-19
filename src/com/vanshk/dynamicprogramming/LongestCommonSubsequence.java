package com.vanshk.dynamicprogramming;

// used in standard impls of diff
public class LongestCommonSubsequence {

	public static int lcs(String x, String y) {
		char[] xArr = x.toCharArray();
		char[] yArr = y.toCharArray();
		int n = xArr.length;
		int m = yArr.length;
		return lcsHelper(xArr, yArr, n, m);
	}

	private static int lcsHelper(char[] xArr, char[] yArr, int n, int m) {
		// DP grid initialization
		int[][] grid = new int[n + 1][m + 1];
		// compute the grid row by row down and from left to right, after that
		// we have everything we need for future subproblems
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (i == 0 || j == 0) {
					grid[i][j] = 0;
				} else if (xArr[i - 1] == yArr[j - 1]) {
					grid[i][j] = grid[i - 1][j - 1] + 1;
				} else {
					grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]);
				}
			}
		}

		return grid[n][m];
	}

	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		System.out.println(lcs(x, y));
	}

}
