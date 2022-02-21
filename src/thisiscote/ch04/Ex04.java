package thisiscote.ch04;

import java.io.*;
import java.util.*;

public class Ex04 {

	public static int N, M, x, y, dir;
	public static int[][] check;
	public static int[][] map;
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int turn = 0;
		int cnt = 1;
		check[x][y] = 1; // 처음 시작점 방문 처리
		while (true) {
			// 왼쪽으로 돌고
			dir--;
			if (dir == -1) dir = 3;
			turn++;
			// 갈 수 있나 확인
			int nx = x + dr[dir];
			int ny = y + dc[dir];
			if (check[nx][ny] == 0 && map[nx][ny] == 0) {
				check[nx][ny] = 1;
				x = nx;
				y = ny;
				turn = 0;
				cnt++;
			}
			// 네 방향 모두 막혔으면
			if (turn == 4) {
				// 뒤로 빽
				x = x - dr[dir];
				y = y - dc[dir];
				turn = 0;
				// 근데 뒤가 바다
				if (map[x][y] == 1) break;
			}
		}
		System.out.println(cnt);
	}

}
