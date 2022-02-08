package DFSnBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13549_숨바꼭질3 {
	static int N, K, ans;
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
		
		find();
		
		System.out.println(ans);
	}
	private static void find() {
		PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		boolean[] visited = new boolean[100001];
		
		pq.offer(new Pos(N, 0));
		
		
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			visited[cur.p] = true;
			
			if(cur.p == K) {
				ans = cur.cnt;
				return;
			}
			
			if(cur.p-1 >= 0 && !visited[cur.p-1]) pq.offer(new Pos(cur.p-1, cur.cnt+1));
			if(cur.p+1 <= 100000 && !visited[cur.p+1]) pq.offer(new Pos(cur.p+1, cur.cnt+1));
			if(cur.p*2 <= 100000 && !visited[cur.p*2]) pq.offer(new Pos(cur.p*2, cur.cnt));
		}
		
	}
}
