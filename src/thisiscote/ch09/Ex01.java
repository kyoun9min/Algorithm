package thisiscote.ch09;

import java.io.*;
import java.util.*;

public class Ex01 {

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
	
	static int N, M, start;
	static List<List<Edge>> graph;
	static int[] dist;
	
	public static void dijkstra(int start) {
		Queue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int now = tmp.index;
			int nowCost = tmp.cost;
			if (nowCost > dist[now]) continue;
			for (Edge ob : graph.get(now)) {
				if (nowCost + ob.cost < dist[ob.index]) {
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
		start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Edge(b, c));
		}
		
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dijkstra(start);
		
		for (int i = 1; i <= N; i++) {
			if (dist[i] == Integer.MAX_VALUE) System.out.println("INFINITY");
			else System.out.println(dist[i]);
		}
	}

}
