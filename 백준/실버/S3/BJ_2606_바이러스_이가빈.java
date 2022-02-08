package DFSnBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_바이러스 {
	static int N, M, ans;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		ans = find();
		
		System.out.println(ans);
		
	}
	private static int find() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];

		q.offer(1);
		visited[1] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < list.get(cur).size(); i++) {
				if(visited[list.get(cur).get(i)]) continue;
				q.offer(list.get(cur).get(i));
				visited[list.get(cur).get(i)] = true;
				cnt++;
			}
		}
		
		return cnt;
		
	}
}
