package p2750;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] a = new int[T];
		
		for (int i = 0; i < T; i++) {
			a[i] = Integer.parseInt(br.readLine()); 
		}
		
		Arrays.sort(a);
		
		for (int n : a) {
			System.out.println(n);
		}
	}

}