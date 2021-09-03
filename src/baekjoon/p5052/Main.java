package baekjoon.p5052;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		boolean flag;
		
		for (int i = 0; i < T; i++) {
			flag = true;
			int N = Integer.parseInt(br.readLine());
			String[] s = new String[N];
			for (int j = 0; j < N; j++)
				s[j] = br.readLine();
			Arrays.sort(s);
			for (int k = 0; k < N - 1; k++) {
				if (s[k + 1].startsWith(s[k])) {
					bw.write("NO\n");
					flag = false;
					break;
				}
			}
			if (flag)
				bw.write("YES\n");
		}
		bw.flush();
		bw.close();
	}

}
