package thisiscote.ch16;

import java.io.*;
import java.util.*;

public class Q01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dr = {-1, 0, 1};
		List<Integer> list = new ArrayList<>();
		while (T != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작점 찾기
			int max = -1;
			int idx = -1;
			for (int i = 0; i < N; i++) {
				if (map[i][0] > max) {
					max = map[i][0];
					idx = i;
				}
			}
			
			int sum = map[idx][0];
			int maxIdx;
			for (int i = 1; i < M; i++) {
				max = 0;
				maxIdx = -1;
				for (int j = 0; j < 3; j++) {
					int newIdx = idx + dr[j];
					if (newIdx >= 0 && newIdx < N)
						if (max < map[newIdx][i]) {
							max = map[newIdx][i];
							maxIdx = newIdx;
						}
				}
				idx = maxIdx;
				sum += max;
			}
			list.add(sum);
			T--;
		}
		for (int x : list) System.out.println(x);
	}

}
