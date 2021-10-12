package baekjoon.p1197;

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int v1, v2;
	int weight;
	
	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Main {

	static int[] parent;
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		for (int i = 1; i < V + 1; i++)
			parent[i] = i;
		
		Queue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(v1, v2, weight));
		}
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (find(curr.v1) != find(curr.v2)) {
				union(curr.v1, curr.v2);
				sum += curr.weight;
			}
		}
		
		System.out.println(sum);
	}
	
	public static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		
		if (p1 < p2)
			parent[p2] = p1;
		else
			parent[p1] = p2;
	}
	
	public static int find(int v) {
		if (parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}

}
