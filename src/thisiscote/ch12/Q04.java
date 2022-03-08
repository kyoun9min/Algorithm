package thisiscote.ch12;

import java.io.*;
import java.util.*;

public class Q04 {

	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int answer = Integer.MAX_VALUE;
	static int[] comb;
	static List<Point> home;
	static List<Point> chicken;
	
	public static void DFS(int L, int s) {
		if (L == M) {
			int sum = 0;
			for (Point h : home) {
				int dist = Integer.MAX_VALUE;
				for (int x : comb) {
					dist = Math.min(dist, Math.abs(chicken.get(x).x - h.x) + Math.abs(chicken.get(x).y - h.y));
				}
				sum += dist;
			}
			answer = Math.min(answer, sum);
		}
		else {
			for (int i = s; i < chicken.size(); i++) {
				comb[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		comb = new int[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) home.add(new Point(i, j));
				else if (tmp == 2) chicken.add(new Point(i, j));
			}
		}
		DFS(0, 0);
		System.out.println(answer);
	}

}
