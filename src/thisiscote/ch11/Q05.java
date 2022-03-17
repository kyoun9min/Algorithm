package thisiscote.ch11;

import java.util.*;
import java.io.*;

public class Q05 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		// 볼링공 무게를 인덱스로 가지는 배열에 해당 무게의 갯수를 입력
		for (int i = 1; i <= N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			arr[idx] += 1;
		}
		
		int answer = 0;
		for (int i = 1; i < M; i++) { // 마지막 공은 볼 필요도 없다.
			N -= arr[i]; // 전체 갯수에서 현재 고른 무게의 갯수를 빼준다.
			answer += arr[i] * N; // 현재 고른 무게의 갯수 x 나머지 공들의 갯수
		}
		System.out.println(answer);
	}

}
