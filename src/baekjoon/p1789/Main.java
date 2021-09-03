package baekjoon.p1789;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();
		long sum = 0;
		long count = 0;
		
		for (int i = 1; i <= T; i++) {
			sum += i;
			if (sum > T) {
				System.out.println(count);
				break;
			}
			count++;
		}
	}

}
