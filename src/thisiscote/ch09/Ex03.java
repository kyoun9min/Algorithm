package thisiscote.ch09;

import java.io.*;
import java.util.*;

public class Ex03 {

	static final int INF = (int)1e9;
	static int N, M, X, K;
	static int[][] graph;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		
		// 무한으로 채우기
		for (int i = 0; i < N + 1; i++)
			Arrays.fill(graph[i], INF);
		// 자기자신은 0으로 채우기
		for (int i = 1; i <= N; i++)
			graph[i][i] = 0;
		// 연결된 거리 1로 채우기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int k = 1; k <= N; k++) {
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		if (graph[1][K] + graph[K][X] >= INF) System.out.println(-1);
		else System.out.println(graph[1][K] + graph[K][X]);
	}

}
