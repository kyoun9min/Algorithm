package p2292;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int a = 1;
		int i = 0;
		
		while (true) {
			a += 6 * i;
			if (a >= num)
				break;
			i++;
		}
		i++;
		System.out.println(i);
	}

}

