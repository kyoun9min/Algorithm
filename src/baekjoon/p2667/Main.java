package baekjoon.p2667;

import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int count;
	static List<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		count = 0;
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				map[i][j] = ch[j] - 48;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !check[i][j]) {
					count = 1;
					dfs(i, j);
					list.add(count);
				}
			}
		}
		
		System.out.println(list.size());
		
		Collections.sort(list);
		for (int n : list)
			System.out.println(n);
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == 1 && !check[nx][ny]) {
					count++;
					dfs(nx, ny);
				}
			}
		}
	}
}

//public class Main {
//	
//	static int N;
//	static int[][] map;
//	static boolean[][] check;
//	static int[] dr = {-1, 1, 0, 0};
//	static int[] dc = {0, 0, -1, 1};
//	static int count;
//	static List<Integer> list;
//	
//	public static void main(String[] args) throws IOException, NumberFormatException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		map = new int[N][N];
//		check = new boolean[N][N];
//		count = 0;
//		list = new ArrayList<>();
//		
//		for (int i = 0; i < N; i++) {
//			char[] ch = br.readLine().toCharArray();
//			for (int j = 0; j < N; j++)
//				map[i][j] = ch[j] - 48;
//		}
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (map[i][j] == 1 && !check[i][j]) {
//					count = 0;
//					bfs(i, j);
//					list.add(count);
//				}
//			}
//		}
//		
//		Collections.sort(list);
//		System.out.println(list.size());
//		for (int n : list)
//			System.out.println(n);
//	}
//	
//	public static void bfs(int x, int y) {
//		Queue<Integer[]> queue = new LinkedList<>();
//		queue.offer(new Integer[] {x, y});
//		while (!queue.isEmpty()) {
//			int currX = queue.peek()[0];
//			int currY = queue.peek()[1];
//			queue.poll();
//			if (!check[currX][currY]) {
//				check[currX][currY] = true;
//				count++;
//				for (int i = 0; i < 4; i++) {
//					int nx = currX + dr[i];
//					int ny = currY + dc[i];
//					
//					if (nx >= 0 && ny >= 0 && nx < N && ny < N)
//						if (map[nx][ny] == 1)
//							queue.offer(new Integer[] {nx, ny});
//				}
//			}
//		}
//	}
//}
