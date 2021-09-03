package baekjoon.p2468;

import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int count;
	static int maxH = 0;
	static int max = 1;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(tokenizer.nextToken());
				if (temp > maxH)
					maxH = temp;
				map[i][j] = temp;
			}
		}
		
		for (int T = 1; T <= maxH; T++) {
			check = new boolean[N][N];
			count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > T && !check[i][j]) {
						dfs(i, j, T);
						count++;
					}
				}
			}
			if (max < count)
				max = count;
		}
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int T) {
		check[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N)
				if (map[nx][ny] > T && !check[nx][ny])
					dfs(nx, ny, T);
		}
	}

}
