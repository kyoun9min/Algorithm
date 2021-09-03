package baekjoon.p1987;

import java.util.*;
import java.io.*;

public class Main {

	static int R;
	static int C;
	static char[][] map;
	static boolean[] check = new boolean[26];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int dist = 1;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 1);
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int dist) {
		check[map[x][y] - 65] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
				if (!check[map[nx][ny] - 65])
					dfs(nx, ny, dist + 1);
			}
		}
		check[map[x][y] - 65] = false;
		if (max < dist)
			max = dist;
	}
}
