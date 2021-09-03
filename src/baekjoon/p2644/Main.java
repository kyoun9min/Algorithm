package baekjoon.p2644;

import java.util.*;
import java.io.*;

public class Main {

	static int V;
	static int E;
	static int[][] map;
	static boolean[] check;
	static int start;
	static int end;
	static int flag = 0;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		start = Integer.parseInt(tokenizer.nextToken());
		end = Integer.parseInt(tokenizer.nextToken());
		E = Integer.parseInt(br.readLine());
		map = new int[V + 1][V + 1];
		check = new boolean[V + 1];
		dist = new int[V + 1];
		
		for (int i = 1; i < E + 1; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tokenizer.nextToken());
			int v = Integer.parseInt(tokenizer.nextToken());
			map[u][v] = map[v][u] = 1;
		}
		
		dfs(start);
		if (flag == 0)
			dist[end] = -1;
		System.out.println(dist[end]);
	}
	
	public static void dfs(int start) {
		check[start] = true;
		if (start == end) {
			flag = 1;
			return;
		}
		for (int next = 1; next < V + 1; next++) {
			if (map[start][next] == 1 && !check[next]) {
				if (flag == 0) {
					dist[next] = dist[start] + 1;
					dfs(next);
				}
				else
					return;		
			}
		}
	}

}