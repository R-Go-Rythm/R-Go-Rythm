package DFSnBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2178_미로탐색 {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static class Pos{
		int y;
		int x;
		int cnt;
		public Pos(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		find();
		
		System.out.println(ans);
		
	}

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	private static void find() {
		PriorityQueue<Pos> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		
		q.offer(new Pos(0, 0, 1));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			if(cur.y == N-1 && cur.x == M-1) {
				ans = cur.cnt;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M || visited[ny][nx] || map[ny][nx] == 0) continue;
				visited[ny][nx] = true;
				q.offer(new Pos(ny, nx, cur.cnt+1));
				
			}
		}
	}
}
