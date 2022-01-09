package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888_연산자끼워넣기 {
	static int N, max, min;
	static int[] num, op;
	static boolean[] visit;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 0 + 1 - 2 * 3 /
		op = new int[N-1];
		visit = new boolean[N-1];
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				op[idx++] = i;
			}
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		// 현재까지의 합, 더해야하는 숫자 인덱스, 사용한 연산자 수
		find(num[0], 1, 0);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	private static void find(int sum, int numIdx, int opCnt) {
		if(opCnt == N-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < N-1; i++) {
			if(visit[i]) continue;
			int tmp = 0;
			switch(op[i]){
			case 0:
				tmp = sum+num[numIdx];
				break;
			case 1:
				tmp = sum-num[numIdx];
				break;
			case 2:
				tmp = sum*num[numIdx];
				break;
			case 3:
				tmp = sum/num[numIdx];
				break;
			}
			visit[i] = true;
			find(tmp, numIdx+1, opCnt+1);
			visit[i] = false;
		}
		
	}
}
