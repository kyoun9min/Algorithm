package thisiscote.ch04;

import java.io.*;
import java.util.*;

public class Ex01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] plan = br.readLine().split(" ");
		char[] move = {'U', 'D', 'L', 'R'};
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int x = 1;
		int y = 1;
		for (int i = 0; i < plan.length; i++) {
			char curr = plan[i].charAt(0);
			for (int j = 0; j < 4; j++) {
				if (curr == move[j]) {
					int nx = x + dr[j];
					int ny = y + dc[j];
					if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
						x = nx;
						y = ny;
					}
				}
			}
		}
		System.out.println(x + " " + y);
	}

}
