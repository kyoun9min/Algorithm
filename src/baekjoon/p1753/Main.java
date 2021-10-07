package baekjoon.p1753;

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
	static int v, e, k;
	static List<Node>[] list;
	static int[] dist;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		list = new ArrayList[v + 1];
		dist = new int[v + 1];
		check = new boolean[v + 1];
		
		Arrays.fill(dist, INF);
		
		for (int i = 1; i <= v; i++)
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		
		dijkstra(k);
		for (int i = 1; i < v + 1; i++) {
			if (dist[i] == INF)
				bw.write("INF\n");
			else
				bw.write(String.valueOf(dist[i]) + "\n");
		}
		bw.flush();
		bw.close();
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
