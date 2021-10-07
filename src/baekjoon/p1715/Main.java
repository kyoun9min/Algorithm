package baekjoon.p1715;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Queue<Long> queue = new PriorityQueue<>();
		long sum = 0;
		
		for (int i = 0; i < T; i++)
			queue.offer(Long.parseLong(br.readLine()));
		
		while (queue.size() > 1) {
			long num1 = queue.poll();
			long num2 = queue.poll();
			queue.offer(num1 + num2);
			sum += num1 + num2;
		}
		
		System.out.println(sum);
	}

}
