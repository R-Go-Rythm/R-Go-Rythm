package Feb_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_12851_숨바꼭질2_BFS {

	static int N, K, min=Integer.MAX_VALUE, cnt=0;
	static boolean[] visited = new boolean[100001];
	static PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p1-p2);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) {			// 이미 같은 위치에 있을 때
			System.out.print(0 + "\n" + 1);
		} else if(N > K) {		// 도착지가 현 위치보다 이전일 때
			System.out.print(N-K + "\n" + 1);
		} else {				// 도착지가 현 위치보다 이후일 때
			bfs();
			System.out.print(min + "\n" + cnt);
		}
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N, 0});
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			visited[cur[0]] = true;		// 방문표시를 큐에 넣을 때마다 수행해서 요류가 났었다.
			
			if(cur[0] == K) {
				min = Math.min(min, cur[1]);
				if(min != cur[1]) break;	// 처음에 도착한 경우가 최단시간이므로 시간별 횟수는 구하지 않아도 된다.
				cnt++;
			}
			
			int next = cur[0]+1;
			if(next <= 100000 && !visited[next]) {
				queue.add(new int[] {next, cur[1]+1});
			}
			next = cur[0]*2;
			if(next <= 100000 && !visited[next]) {
				queue.add(new int[] {next, cur[1]+1});
			}
			next = cur[0]-1;
			if(0 <= next && !visited[next]) {
				queue.add(new int[] {next, cur[1]+1});
			}
		}
	}
}
