package p2751;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new	StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < T; i++)
			list.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(list);
		
		for (int n : list)
			sb.append(n).append('\n');
		
		System.out.println(sb);
	}
}