package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2501_약수구하기 {
	static int N, K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if(N % i == 0) {
				list.add(i);
			}
		}
		if(list.size() < K) System.out.println(0);
		else System.out.println(list.get(K-1));
		
	}
}
