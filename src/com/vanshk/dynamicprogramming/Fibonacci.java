package com.vanshk.dynamicprogramming;

public class Fibonacci {
	
	public static int fib(int n){
		if (n == 0 || n  == 1){
			return n;
		}
		//init
		int a = 0, b = 1, temp;
		//compute nth fibonacci number
		for (int i = 2; i < n; ++i){
			temp = a + b;
			a = b;
			b = temp; 
		}
		return a + b;
	}
	
	public static void main(String[] args) {
		System.out.println(fib(1));
		System.out.println(fib(5));
		System.out.println(fib(10));
		System.out.println(fib(17));
		System.out.println(fib(11));
	}
}
