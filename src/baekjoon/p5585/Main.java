package baekjoon.p5585;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1000 - Integer.parseInt(br.readLine());
		int[] type = {500, 100, 50, 10, 5, 1};
		int count = 0;
		
		for(int i = 0; i < 6; i++) {
			count += T / type[i];
			T %= type[i];
		}
		
		System.out.println(count);
	}

}
