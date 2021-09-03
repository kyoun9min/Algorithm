package baekjoon.p1193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int count = 1;
		
		for (int row = 1; row <= 10000000; row++) {
			for (int col = 1; col <= row; col++) {
				int num1 = col;
				int num2 = row - col + 1;
				
				if (count == x) {
					if (row % 2 == 0)
						System.out.println(num1 + "/" + num2);
					else
						System.out.println(num2 + "/" + num1);
					return;
				}
				count++;
			}
		}
	}
}

