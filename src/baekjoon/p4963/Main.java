package baekjoon.p4963;

import java.util.*;
import java.io.*;

public class Main {

	static int w;
	static int h;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	static int count;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			w = Integer.parseInt(tokenizer.nextToken());
			h = Integer.parseInt(tokenizer.nextToken());
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			check = new boolean[h][w];
			count = 0;
			for (int i = 0; i < h; i++) {
				tokenizer = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++)
					if (map[i][j] == 1 && !check[i][j]) {
						dfs(i, j);
//						bfs(i, j);
						count++;
					}
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx >= 0 && ny >= 0 && nx < h && ny < w)
				if (map[nx][ny] == 1 && !check[nx][ny])
					dfs(nx, ny);
		}
	}
	
//	public static void bfs(int x, int y) {
//		Queue<Integer[]> queue = new LinkedList<>();
//		queue.offer(new Integer[] {x, y});
//		
//		while (!queue.isEmpty()) {
//			int currX = queue.peek()[0];
//			int currY = queue.peek()[1];
//			queue.poll();
//			if (!check[currX][currY]) {
//				check[currX][currY] = true;
//				for (int i = 0; i < 8; i++) {
//					int nx = currX + dr[i];
//					int ny = currY + dc[i];
//					if (nx >= 0 && ny >= 0 && nx < h && ny < w)
//						if (map[nx][ny] == 1)
//							queue.offer(new Integer[] {nx, ny});
//				}
//			}
//			
//		}
//	}

}
