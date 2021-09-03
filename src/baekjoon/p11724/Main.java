package baekjoon.p11724;

import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[] check;
	static int count;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		map = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		count = 0;
		
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tokenizer.nextToken());
			int v = Integer.parseInt(tokenizer.nextToken());
			map[u][v] = map[v][u] = 1;
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (!check[i]) {
				bfs(i);
//				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (!check[curr]) {
				check[curr] = true;
				for (int next = 1; next < N + 1; next++)
					if (map[curr][next] == 1)
						queue.offer(next);
			}
		}
	}
	
//	public static void dfs(int start) {
//		check[start] = true;
//		for (int next = 1; next < N + 1; next++)
//			if (map[start][next] == 1 && !check[next])
//				dfs(next);
//	}

}
