package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1789_수들의합 {
	static long S;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Long.parseLong(br.readLine());
		
		long sum = 0;
		int cnt = 0;
		// 1부터 하나씩 더해간다.
		for (int i = 1; i <= S; i++) {
			if(S > sum) {
				sum+=i;
				cnt++;
			}
			// sum이 S보다 크거나 같은 경우
			if(S <= sum) {
				// 같은 경우에는 딱 그 개수만큼 더하면 된다.
				if(sum==S) ans = cnt;
				// S보다 큰 경우
				// 마지막에 더한 수를 p라고 하고, p를 더하기 전까지의 합을 prevSum 이라고 하자.
				// prevSum+p > S 이고 1+2+..+p-1 < S 이기때문에
				// 현재 합에서 1에서 p-1사이의 어떤 숫자를 빼면 S가 된다.
				else ans = cnt-1;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
