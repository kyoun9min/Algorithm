package baekjoon.p1026;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		
		StringTokenizer tokenizerA = new StringTokenizer(br.readLine());
		StringTokenizer tokenizerB = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			listA.add(Integer.parseInt(tokenizerA.nextToken()));
			listB.add(Integer.parseInt(tokenizerB.nextToken()));
		}
		
		Collections.sort(listA);
		
		int S = 0;
		int max = 0;
		
		for (int i = 0; i < T; i++) {
			max = Collections.max(listB);
			S += listA.get(i) * max;
			listB.remove(Integer.valueOf(max));
		}
		
		System.out.println(S);
	}

}
