package thisiscote.ch12;

import java.util.*;
import java.io.*;

public class Q02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String alpha = s.replaceAll("[^A-Z]", "");
		String num = s.replaceAll("[^0-9]", "");
		
		char[] alphaArr = alpha.toCharArray();
		Arrays.sort(alphaArr);
		alpha = String.valueOf(alphaArr);
		
		int sum = 0;
		for (int i = 0; i < num.length(); i++)
			sum += num.charAt(i) - 48;
		
		if (sum == 0) System.out.println(alpha);
		else System.out.println(alpha + sum);
	}

}
