package thisiscote.ch06;

import java.io.*;
import java.util.*;

public class Ex02 {

	static class Student implements Comparable<Student> {
		String name;
		int score;
		
		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}
		
		@Override
		public int compareTo(Student o) {
			return this.score - o.score;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			list.add(new Student(name, score));
		}
		Collections.sort(list);
		for (Student s : list)
			System.out.print(s.name + " ");
	}

}
