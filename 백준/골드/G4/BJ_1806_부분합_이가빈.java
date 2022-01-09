package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806_부분합 {
	static int N, S, ans;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = arr[0];
		while(start < N && end < N && start<=end) {
			
			if(sum < S) {
				sum += arr[++end];
			} else {
				ans = Math.min(ans, end-start+1);
				sum-=arr[start++];
			}
		}
		if(ans == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
	}
}
