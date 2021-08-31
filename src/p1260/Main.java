package p1260;

import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static boolean[] check;
	static int N;
	static int M;
	static int V;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		V = Integer.parseInt(tokenizer.nextToken());
		map = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tokenizer.nextToken());
			int v = Integer.parseInt(tokenizer.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		dfs(V);
		
		check = new boolean[N + 1];
		System.out.println();
		
		bfs(V);
	}
	
	public static void dfs(int V) {
		check[V] = true;
		System.out.print(V + " ");
		
		for (int next = 1; next < N + 1; next++) {
			if (map[V][next] == 1 && !check[next])
				dfs(next);
		}
	}
	
	public static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (!check[curr]) {
				check[curr] = true;
				System.out.print(curr + " ");
				for (int next = 1; next < N + 1; next++)
					if (map[curr][next] == 1)
						queue.offer(next);
			}
		}
	}
}

//public class Main {
//	
//	static List<Integer>[] list;
//
//	public static void dfs(int V) {
//		Queue<Integer> visitedQueue = new LinkedList<>();
//		Stack<Integer> needVisitStack = new Stack<>();
//		needVisitStack.push(V);
//		while (!needVisitStack.isEmpty()) {
//			int currentVertex = needVisitStack.pop();
//			if (!visitedQueue.contains(currentVertex)) {
//				visitedQueue.add(currentVertex);
//				System.out.print(currentVertex + " ");
//				for (int adjacentVertex : list[currentVertex])
//					needVisitStack.add(adjacentVertex);
//			}
//		}
//	}
//	
//	public static void bfs(int V) {
//		Queue<Integer> visitedQueue = new LinkedList<>();
//		Queue<Integer> needVisitQueue = new LinkedList<>();
//		needVisitQueue.add(V);
//		while (!needVisitQueue.isEmpty()) {
//			int	currentVertex = needVisitQueue.remove();
//			if (!visitedQueue.contains(currentVertex)) {
//				visitedQueue.add(currentVertex);
//				System.out.print(currentVertex + " ");
//				for (int adjacentVertex : list[currentVertex])
//					needVisitQueue.add(adjacentVertex);
//			}
//		}
//	}
//	
//	public static void main(String[] args) throws IOException, NumberFormatException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(tokenizer.nextToken());
//		int M = Integer.parseInt(tokenizer.nextToken());
//		int V = Integer.parseInt(tokenizer.nextToken());
//		list = new ArrayList[N + 1];
//		
//		for (int i = 1; i < N + 1; i++) {
//			list[i] = new ArrayList<Integer>();
//		}
//		
//		for (int i = 0; i < M; i++) {
//			tokenizer = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(tokenizer.nextToken());
//			int b = Integer.parseInt(tokenizer.nextToken());
//			list[a].add(b);
//			list[b].add(a);
//		}
//		
//		for (int i = 1; i < N + 1; i++)
//			Collections.sort(list[i], Collections.reverseOrder());
//		
//		dfs(V);
//		
//		System.out.println();
//		
//		for (int i = 1; i < N + 1; i++)
//			Collections.sort(list[i]);
//		
//		bfs(V);
//	}
//
//}
