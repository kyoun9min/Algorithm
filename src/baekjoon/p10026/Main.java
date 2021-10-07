package baekjoon.p10026;

import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static char[][] map;
	static boolean[][] check;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int count = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		bw.write(String.valueOf(count) + " ");
		
		check = new boolean[N][N];
		count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					RGdfs(i, j);
					count++;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if ((map[x][y] == map[nx][ny]) && !check[nx][ny])
					dfs(nx, ny);
			}
		}
	}
	
	public static void RGdfs(int x, int y) {
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (((map[x][y] == map[nx][ny]) || (map[x][y] == 'R' && map[nx][ny] == 'G') 
						|| (map[x][y] == 'G' && map[nx][ny] == 'R')) && !check[nx][ny])
					RGdfs(nx, ny);
			}
		}
	}

}

// 맵을 2개로. 하지만 결국 dfs를 2가지 쓰게 됐다. for문 전체 한번 또 돌면서 R을 G로 바꿔주기 싫어서.
//public class Main {
//	
//	static int N;
//	static char[][] map;
//	static char[][] RGmap;
//	static boolean[][] check;
//	static int[] dr = {-1, 1, 0, 0};
//	static int[] dc = {0, 0, -1, 1};
//	static int count = 0;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		N = Integer.parseInt(br.readLine());
//		map = new char[N][N];
//		RGmap = new char[N][N];
//		check = new boolean[N][N];
//		
//		for (int i = 0; i < N; i++) {
//			char[] ch = br.readLine().toCharArray();
//			for (int j = 0; j < N; j++) {
//				if (ch[j] == 'R' || ch[j] == 'G') {
//					map[i][j] = ch[j];
//					RGmap[i][j] = 'R';
//				}
//				else
//					map[i][j] = RGmap[i][j] = ch[j];
//			}
//		}
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (!check[i][j]) {
//					dfs(i, j);
//					count++;
//				}
//			}
//		}
//		
//		sb.append(count + " ");
//		check = new boolean[N][N];
//		count = 0;
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (!check[i][j]) {
//					RGdfs(i, j);
//					count++;
//				}
//			}
//		}
//		
//		sb.append(count);
//		System.out.println(sb);
//		
//	}
//	
//	public static void dfs(int x, int y) {
//		check[x][y] = true;
//		
//		for (int i = 0; i < 4; i++) {
//			int nx = x + dr[i];
//			int ny = y + dc[i];
//			if (nx >= 0 && ny >= 0 && nx < N && ny < N)
//				if (map[x][y] == map[nx][ny] && !check[nx][ny])
//					dfs(nx, ny);
//		}
//	}
//	
//	public static void RGdfs(int x, int y) {
//		check[x][y] = true;
//		
//		for (int i = 0; i < 4; i++) {
//			int nx = x + dr[i];
//			int ny = y + dc[i];
//			if (nx >= 0 && ny >= 0 && nx < N && ny < N)
//				if (RGmap[x][y] == RGmap[nx][ny] && !check[nx][ny])
//					RGdfs(nx, ny);
//		}
//	}
//}
