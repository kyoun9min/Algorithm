package thisiscote.ch05;

import java.io.*;
import java.util.*;

public class Ex01 {

	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int count = 0;
	
	public static void DFS(int x, int y) {
		map[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0)
				DFS(nx, ny);
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					DFS(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
