package baekjoon.p1012;

import java.util.*;
import java.io.*;

public class Main {

	static int T;
	static int M;
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int count;
	
	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		while (T-- != 0) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			M = Integer.parseInt(tokenizer.nextToken());
			N = Integer.parseInt(tokenizer.nextToken());
			K = Integer.parseInt(tokenizer.nextToken());
			map = new int[M][N];
			check = new boolean[M][N];
			count = 0;
			
			for (int i = 0; i < K; i++) {
				tokenizer = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				map[u][v] = 1;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !check[i][j]) {
						dfs(i, j);
//						bfs(i, j);
						count++;
					}
				}
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (nx >= 0 && ny >= 0 && nx < M && ny < N)
				if (map[nx][ny] == 1 && !check[nx][ny])
					dfs(nx, ny);
		}
	}
	
//	public static void bfs(int x, int y) {
//		Queue<Integer[]> queue = new LinkedList<>();
//		queue.offer(new Integer[] {x, y});
//		while (!queue.isEmpty()) {
//			int currX = queue.peek()[0];
//			int currY = queue.peek()[1];
//			queue.poll();
//			if (!check[currX][currY]) {
//				check[currX][currY] = true;
//				for (int i = 0; i < 4; i++) {
//					int nx = currX + dr[i];
//					int ny = currY + dc[i];
//					
//					if (nx >= 0 && ny >= 0 && nx < M && ny < N)
//						if (map[nx][ny] == 1)
//							queue.offer(new Integer[] {nx, ny});
//				}
//			}
//		}
//	}

}
