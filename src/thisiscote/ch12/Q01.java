package thisiscote.ch12;

import java.util.*;
import java.io.*;

public class Q01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int sum = 0;
		for (int i = 0; i < s.length() / 2; i++)
			sum += s.charAt(i) - 48;
		for (int i = s.length() / 2; i < s.length(); i++)
			sum -= s.charAt(i) - 48;
		
		if (sum == 0) System.out.println("LUCKY");
		else System.out.println("READY");
	}

}
