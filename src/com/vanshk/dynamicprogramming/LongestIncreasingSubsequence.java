package com.vanshk.dynamicprogramming;

import java.util.Arrays;

//Computes length of lis
public class LongestIncreasingSubsequence {

	public static int lis(int[] arr) {
		int max = 1;
		// init
		int[] lisArray = new int[arr.length];
		Arrays.fill(lisArray, 1);

		// compute lis ending at index i
		for (int i = 1; i < arr.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[i] > arr[j] && lisArray[i] < lisArray[j] + 1) {
					lisArray[i] = lisArray[j] + 1;
					if (lisArray[i] > max) {
						max = lisArray[i];
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 50, 3, 10, 7, 40, 80 };
		System.out.println(lis(arr));
	}
}
