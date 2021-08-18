package p10867;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < T; i++)
			set.add(tokenizer.nextToken());
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}

}
