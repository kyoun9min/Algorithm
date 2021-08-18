package p1026;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Integer[] a = new Integer[T];
		Integer[] b = new Integer[T];
		
		StringTokenizer tokenizerA = new StringTokenizer(br.readLine());
		StringTokenizer tokenizerB = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			a[i] = Integer.parseInt(tokenizerA.nextToken());
			b[i] = Integer.parseInt(tokenizerB.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		int S = 0;
		
		for (int i = 0; i < T; i++)
			S += a[i] * b[i];
		
		System.out.println(S);
	}

}
