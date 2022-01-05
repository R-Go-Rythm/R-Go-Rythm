package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719_빗물 {
	static int H, W, leftMax, rightMax, ans;
	static int[] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < W; i++) {
			// 현재 가로(1개) 블록을 기준으로
			leftMax = 0;
			// 왼쪽에서 가장 높은 블록을 찾고
			for (int j = i-1; j >= 0; j--) {
				leftMax = Math.max(leftMax, map[j]);
			}
			rightMax = 0;
			// 오른쪽에서 가장 높은 블록을 찾는다.
			for (int j = i+1; j < W; j++) {
				rightMax = Math.max(rightMax, map[j]);
			}
			// 각 양쪽 블록의 높이 보다 현재 블록의 높이가 작다면
			// 빗물이 고일 수 있다
			if(leftMax > map[i] && rightMax > map[i]) {
				// 단, 고일 수 있는 양은 두 높이 중 낮은 높이에서 현재 블록의 높이를 뺀것만큼!
				ans += Math.min(leftMax, rightMax) - map[i];
			}
				
		}
		
		 System.out.println(ans);
	}
}
