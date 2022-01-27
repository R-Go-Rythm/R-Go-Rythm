package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070_파이프옮기기1 {
	// state는 현재 상태 가로 0, 세로 1, 대각선 2
	static int N, ans;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// r, c번호는 1부터 시작
		map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 파이프는 두칸을 차지 하므로
		// 첫 시작의 가장 오른쪽 끝 좌표는 y는 1, x는 2
		// 첫 시작 상태는 가로인 0
		find(1, 2, 0);
		
		System.out.println(ans);
		
	}
	// 가로, 세로, 대각선
	static int[] dy = {0, 1, 1};
	static int[] dx = {1, 0, 1};
	private static void find(int y, int x, int state) {
		if(y==N && x==N) {
			ans++;
			return;
		}

		
		for (int d = 0; d < 3; d++) {
			
			int ny = y+dy[d];
			int nx = x+dx[d];
			
			// 범위 밖을 벗어나거나 벽이라면 이동 불가능
			if(nx> N || ny> N || map[ny][nx] == 1) continue;
			// 가로 방향와 세로 방향간에는 이동할 수 없음
			if((state==0 && d==1) || (state==1 && d==0)) continue;
			// 대각선으로 이동할자리의 위와 왼쪽은 비워져있어야한다.
			if(d==2 && (map[ny][nx-1] == 1 || map[ny-1][nx] == 1)) continue;
			
			find(ny, nx, d);
		}
		
	}
}
