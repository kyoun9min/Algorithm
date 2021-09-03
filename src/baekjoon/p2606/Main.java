package baekjoon.p2606;

import java.util.*;
import java.io.*;

public class Main {

	static int V;
	static int E;
	static int[][] map;
	static boolean[] check;
	static int count;
	
	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		map = new int[V + 1][V + 1];
		check = new boolean[V + 1];
		
		StringTokenizer tokenizer;
		for (int i = 0; i < E; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tokenizer.nextToken());
			int v = Integer.parseInt(tokenizer.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		dfs(1);
//		bfs(1);
		System.out.println(count - 1);
	}
	
	public static void dfs(int start) {
		check[start] = true;
		count++;
		
		for (int next = 1; next < V + 1; next++) {
			if (map[start][next] == 1 && !check[next])
				dfs(next);
		}
	}
	
//	public static void bfs(int start) {
//		Queue<Integer> queue = new LinkedList<>();
//		queue.offer(start);
//		while (!queue.isEmpty()) {
//			int curr = queue.poll();
//			if (!check[curr]) {
//				check[curr] = true;
//				count++;
//				for (int next = 1; next < V + 1; next++)
//					if (map[curr][next] == 1)
//						queue.offer(next);
//			}
//		}
//	}

}
