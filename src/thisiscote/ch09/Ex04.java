package thisiscote.ch09;

import java.io.*;
import java.util.*;

public class Ex04 {

	static class Edge implements Comparable<Edge> {
		int index;
		int cost;
		
		public Edge(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M, C;
	static List<List<Edge>> graph;
	static int[] dist;
	
	public static void dijkstra(int C) {
		Queue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(C, 0));
		dist[C] = 0;
		
		while (!pq.isEmpty()) {
			Edge temp = pq.poll();
			int now = temp.index;
			int nowCost = temp.cost;
			if (nowCost > dist[now]) continue;
			for (Edge ob : graph.get(now)) {
				if (dist[ob.index] > nowCost + ob.cost) {
					dist[ob.index] = nowCost + ob.cost;
					pq.offer(new Edge(ob.index, nowCost + ob.cost));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			graph.get(x).add(new Edge(y, z));
		}
		
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dijkstra(C);
		
		int count = -1; // 시작 도시는 제외해야 하므로 -1 해주는 것 대신 -1로 시작
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] != Integer.MAX_VALUE) {
				count++;
				max = Math.max(max, dist[i]);
			}
		}
		
		System.out.println(count + " " + max);
	}

}
