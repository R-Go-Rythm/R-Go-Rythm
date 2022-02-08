package DFSnBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851_숨바꼭질2 {
	static int N, K, minTime, ansCnt;
	static boolean[] visited;
	static class Pos{
		int p;
		int cnt;
		public Pos(int p, int cnt) {
			super();
			this.p = p;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		minTime = Integer.MAX_VALUE;
		
		find();
		
		System.out.println(minTime);
		System.out.println(ansCnt);
		
	}
	private static void find() {
		visited = new boolean[100001];
		
		Queue<Pos> q = new LinkedList<>();
		
		q.offer(new Pos(N, 0));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			visited[cur.p] = true;
			
			if(cur.p == K) {
				minTime = Math.min(minTime, cur.cnt);
				// 가장 빠른 시간으로 갈수 있는 방법의 수니까 bfs를 수행하는 상태에서
				// 최소 시간이 아니라면 더 이상 돌 필요가 없다.
				if(minTime != cur.cnt) return;
				ansCnt++;
			}
			
			if(cur.p-1>=0 && !visited[cur.p-1]) q.offer(new Pos(cur.p-1, cur.cnt+1));
			if(cur.p+1<=100000 && !visited[cur.p+1]) q.offer(new Pos(cur.p+1, cur.cnt+1));
			if(cur.p*2<=100000 && !visited[cur.p*2]) q.offer(new Pos(cur.p*2, cur.cnt+1));
		}

	}
}
