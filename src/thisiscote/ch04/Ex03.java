package thisiscote.ch04;

import java.io.*;
import java.util.*;

public class Ex03 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int x = s.charAt(1) - 48;
		int y = s.charAt(0) - 97 + 1;
		int[] dr = {-1, -2, -2, -1, 1, 2, 1, 2};
		int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx >= 1 && nx <= 8 && ny >=1 && ny <= 8) cnt++;
		}
		System.out.println(cnt);
	}

}
