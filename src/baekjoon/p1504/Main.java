package baekjoon.p1504;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class Main {

	static final int INF = 100_000_000;
	static int N, E, v1, v2;
	static List<Node>[] list;
	static int[] dist;
	static boolean[] check;
	static int sum1 = 0;
	static int sum2 = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		dist = new int[N + 1];
		check = new boolean[N + 1];
		
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		// 1 -> v1 -> v2 -> N
		Arrays.fill(dist, INF);
		dijkstra(1);
		sum1 += dist[v1];
		
		Arrays.fill(dist, INF);
		check = new boolean[N + 1];
		dijkstra(v1);
		sum1 += dist[v2];
		
		Arrays.fill(dist, INF);
		check = new boolean[N + 1];
		dijkstra(v2);
		sum1 += dist[N];
		
		
		// 1 -> v2 -> v1 -> N
		Arrays.fill(dist, INF);
		check = new boolean[N + 1];
		dijkstra(1);
		sum2 += dist[v2];
		
		Arrays.fill(dist, INF);
		check = new boolean[N + 1];
		dijkstra(v2);
		sum2 += dist[v1];
		
		Arrays.fill(dist, INF);
		check = new boolean[N + 1];
		dijkstra(v1);
		sum2 += dist[N];
		
		if (INF <= sum1 && INF <= sum2)
			System.out.println(-1);
		else
			System.out.println(Math.min(sum1, sum2));
	}
	
	public static void dijkstra(int start) {
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll().end;
			
			if (!check[curr]) {
				check[curr] = true;
				
				for (Node node : list[curr]) {
					if (dist[curr] + node.weight < dist[node.end]) {
						dist[node.end] = dist[curr] + node.weight;
						queue.offer(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
	}

}
