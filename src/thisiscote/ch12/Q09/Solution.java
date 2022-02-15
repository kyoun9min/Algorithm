package thisiscote.ch12.Q09;

import java.io.*;

public class Solution {

	public int solution(String s) {
		int answer = s.length(); // 압축한 문자열은 초기 문자열의 길이를 넘어 설 수 없다. 이렇게 초기화 해두면 s.length() = 1 인 경우도 커버 가능
		
		for (int unit = 1; unit <= s.length() / 2; unit++) { // 문자를 자르는 단위 (절반길이 까지만 해보면 됨)
			String result = "";
			String prev = s.substring(0, unit);
			int cnt = 1;
			for (int i = unit; i < s.length(); i += unit) {
				String next = "";
				// ArrayIndexOutOfBoundsException을 막기위한 if문
				if (i + unit < s.length()) next = s.substring(i, i + unit);
				// s.length()의 범위를 벗어나게 되면 prev의 문자열보다 next가 짧다는 말이니 다음 if-else 문은 무조건 else로 빠지면서 끝
				// ex) abcabcdede 를 3개씩 자르면서 마지막 부분을 체크해보기
				else next = s.substring(i, s.length());
				if (prev.equals(next)) cnt++;
				else {
					if (cnt == 1)
						result += prev;
					else {
						result += cnt + prev;
						cnt = 1;
					}
					prev = next;
				}
			}
			if (cnt == 1) result += prev;
			else result += cnt + prev;
			answer = Math.min(answer, result.length());
		}
		
		return answer;
	}

// 	<이전 풀이>
//	public int solution(String s) {
//        if (s.length() == 1)
//            return 1;
//        
//        int answer;
//        int min = 1001;
//        for (int i = 1; i <= s.length() / 2; i++) {
//            String now = "";
//            String next = "";
//            String result = "";
//            int count = 1;
//            for (int j = 0; j <= s.length() / i; j++) {
//                int start = i * j;
//                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
//                now = next;
//                next = s.substring(start, end);
//                if(now.equals(next)) {
//                    count++;
//                }
//                else {
//                    if (count > 1) {
//                        result += (String.valueOf(count) + now);
//                        count = 1;
//                    }
//                    else
//                        result += now;
//                }
//            }
//            if (count > 1)
//                result += (String.valueOf(count) + next);
//            else
//                result += next;
//            System.out.println(result.length());
//            if (min > result.length())
//                min = result.length();
//        }
//        answer = min;
//        return answer;
//     }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Solution T = new Solution();
		System.out.println(T.solution(s));
	}
}
