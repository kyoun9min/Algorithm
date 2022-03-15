package baekjoon.p1022;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int N = r2 - r1 + 1;
		int M = c2 - c1 + 1;
		int[][] map = new int[N][M];
		int[] dr = {0, -1, 0, 1}; // →↑←↓
		int[] dc = {1, 0, -1, 0};
		int dir = 0;
		int num = 1;
		int dnum = 1; // 현재 dir 방향으로 반복할 횟수. → ↑ ←← ↓↓ →→→ ↑↑↑ 이런식으로 2번에 걸쳐 한번씩 반복횟수가 늘어나는데, 이는 ↑ or ↓ 일 때 마다 횟수가 증가한다.
		int cnt = 0; // 현재 방향으로 몇 번 반복했는지 카운트 해준다.
		int max = 0; // 예쁘게 출력을 하기 위해 최대값을 저장할 변수. 최대값의 길이를 구해야 하기 떄문.
		int x = -r1; // 새로 생성한 배열의 입장에서 봤을 때의 1의 시작위치
		int y = -c1;
		
		while (!(map[0][0] != 0 && map[0][M - 1] != 0 && map[N - 1][0] != 0 && map[N - 1][M - 1] != 0)) {
			if (x >= 0 && x < N && y >= 0 && y < M) {
				map[x][y] = num;
			}
			num++;
			cnt++;
			x = x + dr[dir];
			y = y + dc[dir];
			
			if (cnt == dnum) {
				cnt = 0;
				if (dir == 1 || dir == 3) dnum++;
				dir++;
				if (dir == 4) dir = 0;
			}
		}
		max = num - 1;
		
		int maxLen = String.valueOf(max).length();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int currLen = String.valueOf(map[i][j]).length();
				for (int k = 0; k < maxLen - currLen; k++) System.out.print(" "); // 제일 긴 숫자가 3자리고 현재 숫자가 1자리면, 둘의 차이인 두칸을 공백으로 먼저 채운다. 
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
