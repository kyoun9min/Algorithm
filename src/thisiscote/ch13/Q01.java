package thisiscote.ch13;

import java.util.*;
import java.io.*;

public class Q01 {

	static int N, M, K, X;
	static List<List<Integer>> graph;
	static int[] ch, dis;
	static boolean flag = false;
	
	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		ch[v] = 1;
		dis[v] = 0;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int nx : graph.get(curr)) {
				if (ch[nx] == 0) {
					ch[nx] = 1;
					queue.offer(nx);
					dis[nx] = dis[curr] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		ch = new int[N + 1];
		dis = new int[N + 1];
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		BFS(X);
		for (int i = 1; i <= N; i++) {
			if (dis[i] == K) {
				flag = true;
				System.out.println(i);
			}
		}
		if (!flag) System.out.println(-1);
	}

}
