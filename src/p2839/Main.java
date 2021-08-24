package p2839;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int count = 0;
		
		while (T != 0) {
			if (T % 5 == 0) {
				count += T / 5;
				break;
			}
			T -= 3;
			count++;
			
			if (T < 0) {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}

}
