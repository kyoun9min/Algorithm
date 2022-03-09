package baekjoon.p11005;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Stack<Character> stack = new Stack<>();
		while (N > 0) {
			if (N % B < 10) {
				stack.add((char)(N % B + 48));
			}
			else {
				stack.add((char)(N % B - 10 + 65));
			}
			N /= B;
		}
		while (!stack.isEmpty()) System.out.print(stack.pop());
	}

}
