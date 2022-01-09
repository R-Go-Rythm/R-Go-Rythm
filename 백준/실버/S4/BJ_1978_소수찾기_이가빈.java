package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체
// 소수의 배수를 지우면 남은 것은 소수가 된다
public class BOJ1978_소수찾기 {
	static int N, ans;
	static boolean[] isPrime;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 소수는 false 표시
		isPrime = new boolean[1001];
		// 0과 1은 소수가 아님
		isPrime[0] = isPrime[1] = true;
		
		for (int i = 2; i*i <= 1000; i++) {
			if(!isPrime[i]) {
				// 소수의 배수를 제외
				for (int j = i*i; j <= 1000; j+= i) {
					isPrime[j] = true;
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!isPrime[num]) ans++;
		}
		
		System.out.println(ans);
	}
}
