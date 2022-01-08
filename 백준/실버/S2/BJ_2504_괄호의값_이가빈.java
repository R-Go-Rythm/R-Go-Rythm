package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504_괄호의값 {
	static String str;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		
		if(str.length()%2 != 1) {
			find();
		}
		System.out.println(ans);
	}

	private static void find() {
		int tmp = 1;
		// 분배 법칙
		Stack<Character> op = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			switch (cur) {
			case '(':
				tmp *= 2;
				op.push(cur);
				break;
			case '[':
				tmp *= 3;
				op.push(cur);
				break;
			case ')':
				if(op.isEmpty() || op.peek() != '(') {
					ans = 0;
					return;
				}
				if(str.charAt(i-1)=='(') {
					ans += tmp;
				}
				op.pop();
				tmp /= 2;
				break;
			case ']':
				if(op.isEmpty() || op.peek() != '[') {
					ans = 0;
					return;
				}
				if(str.charAt(i-1)=='[') {
					ans += tmp;
				}
				op.pop();
				tmp /= 3;
				break;
			}
		}
		
		if(!op.isEmpty()) {
			ans = 0;
			return;
		}
	}

}
