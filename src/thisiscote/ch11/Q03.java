package thisiscote.ch11;

import java.util.*;
import java.io.*;

public class Q03 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String s = br.readLine() + " "; // 마지막에 같은숫자로 끝나는 경우 카운팅이 안되는 것을 방지하기 위해 공백문자 하나 넣기
		int cnt0 = 0;
		int cnt1 = 0;
		
		for (int i = 0; i < s.length() - 1; i++) { // 현재 값과 바로 뒤에 값을 비교하다가 인덱스 에러나지 않게 끝 값 전까지만
			// 같을 때는 지나가고 달라질 때 카운팅
			if (s.charAt(i) != s.charAt(i + 1)) {
				// 모두 0으로 만들기
				if (s.charAt(i) == '1') cnt0++;
				// 모두 1로 만들기
				else cnt1++;
			}
//			// 모두 0으로 만들기
//			if (s.charAt(i) == '1') {
//				if (s.charAt(i) != s.charAt(i + 1)) cnt0++; // 값이 같으면 그냥 지나가다가 달라질 때 카운트
//			}
//			// 모두 1로 만들기
//			else {
//				if (s.charAt(i) != s.charAt(i + 1)) cnt1++;
//			}
		}
		
//		System.out.println("cnt0 : " + cnt0);
//		System.out.println("cnt1 : " + cnt1);
		System.out.println(Math.min(cnt0, cnt1));
	}

//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String s = br.readLine();
//		int cnt0 = 0;
//		int cnt1 = 0;
//		for (int i = 0; i < s.length() - 1; i++) {
//			if (s.charAt(i) == '0') {
//
//				if (s.charAt(i) != s.charAt(i + 1)) cnt1++;
//			}
//			else {
//				if (s.charAt(i) != s.charAt(i + 1)) cnt0++;
//			}
//		}
//		if (s.charAt(s.length() - 1) == '0') cnt1++;
//		else cnt0++;
//		System.out.println(Math.min(cnt0, cnt1));
//	}

}