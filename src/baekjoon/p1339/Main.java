package baekjoon.p1339;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] s = new String[T];
		Integer[] alphabet = new Integer[26];
		Arrays.fill(alphabet, 0);
		for (int i = 0; i < T; i++) {
			s[i] = br.readLine();
			for (int j = 0; j < s[i].length(); j++) {
				int index = s[i].charAt(j) - 65;
				alphabet[index] += (int)Math.pow(10, (s[i].length() - 1 - j));
			}
		}
		Arrays.sort(alphabet, Collections.reverseOrder());
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += (9 - i) * alphabet[i];
		}
		System.out.println(sum);
	}

}
