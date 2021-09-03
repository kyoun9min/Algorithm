package baekjoon.p1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static void fib(int n) {
		int[] cnt0 = new int[Math.max(2, n + 1)];
		int[] cnt1 = new int[Math.max(2, n + 1)];
		cnt0[0] = 1;
		cnt0[1] = 0;
		cnt1[0] = 0;
		cnt1[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			cnt0[i] = cnt0[i - 1] + cnt0[i - 2];
			cnt1[i] = cnt1[i - 1] + cnt1[i - 2];
		}
		System.out.println(cnt0[n] + " " + cnt1[n]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(reader.readLine());
		for (int i = 0; i < count; i++) {
			int n = Integer.parseInt(reader.readLine());
			fib(n);
		}
		
	}
}

//재귀 구현 (시간 초과 뜸)
//package p1003;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	static int fib0(int n) {
//		if (n == 0)
//			return 1;
//		if (n == 1)
//			return 0;
//		return fib0(n - 1) + fib0(n - 2);
//	}
//	
//	static int fib1(int n) {
//		if (n == 0)
//			return 0;
//		if (n == 1)
//			return 1;
//		return fib1(n - 1) + fib1(n - 2);
//	}
//	
//	static void printFib(int n) {
//		System.out.println(fib0(n) + " " + fib1(n));
//	}
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int count = Integer.parseInt(reader.readLine());
//		for (int i = 0; i < count; i++) {
//			int n = Integer.parseInt(reader.readLine());
//			printFib(n);
//		}
//		
//	/*
//		try (Scanner sc = new Scanner(System.in)) {
//			int count = sc.nextInt();
//			for (int i = 0; i < count; i++) {
//				int n = sc.nextInt();
//				printFib(n);
//			}
//		}
//	*/	
//	}
//
//}
