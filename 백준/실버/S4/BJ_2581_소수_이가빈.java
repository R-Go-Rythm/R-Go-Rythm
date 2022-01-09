package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2581_소수 {
	static int M, N, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] isPrime = new boolean[10001];
		isPrime[0] = isPrime[1] = true;
		
		for (int i = 2; i*i <= 10000; i++) {
			if(!isPrime[i]) {
				for (int j = i*i; j <= 10000; j+= i) {
					isPrime[j] = true;
				}
			}
		}
		
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int min = 0;
		for (int i = M; i <= N; i++) {
			if(!isPrime[i]) {
				if(cnt == 0) {
					min = i;
				}
				cnt++;
				ans += i;
			}
		}
		
		if(cnt == 0) System.out.println(-1);
		else {
			System.out.println(ans);
			System.out.println(min);
		}
		
	}
}
