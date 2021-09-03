package baekjoon.p10162;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] type = {300, 60, 10};
		int[] answer = {0, 0, 0};
		
		for (int i = 0; i < 3; i++) {
			answer[i] = T / type[i];
			T %= type[i];
		}
		
		if (T != 0)
			System.out.println("-1");
		else
			System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}

}
