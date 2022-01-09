package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10870_피보나치수5 {
	static int n, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		
		if (n == 0) System.out.println(0);
		else if (n == 1) System.out.println(1);
		else {
			int start = 2;
			int prev1 = 0;
			int prev2 = 1;
			while(true){
				if(start > n) break;
				ans = prev1 + prev2;
				prev1 = prev2;
				prev2 = ans;
				start++;
			}
			System.out.println(ans);
		}

		
	}
}
