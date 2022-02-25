package thisiscote.ch05;

import java.io.*;
import java.util.*;

public class Ex02 {

	static int N, M;
	static int[][] map;
	static int[][] dist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void BFS(int x, int y) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.offer(new Integer[] {x, y});
		map[x][y] = 0;
		dist[x][y] = 1;
		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			int currX = temp[0];
			int currY = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = currX + dr[i];
				int ny = currY + dc[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1) {
					map[nx][ny] = 0;
					queue.offer(new Integer[] {nx, ny});
					dist[nx][ny] = dist[currX][currY] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = s.charAt(j) - 48;
		}
		BFS(0, 0);
		System.out.println(dist[N - 1][M - 1]);
	}

}
