package baekjoon.p1916;

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
	static int N;
	static int M;
	static int start;
	static int end;
	static List<Node>[] list;
	static int[] dist;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		dist = new int[N + 1];
		check = new boolean[N + 1];
		
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(dist[end]);
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

