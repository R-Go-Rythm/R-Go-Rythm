package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2460_지능형기차2 {
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cur = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int out = Integer.parseInt(st.nextToken());
			
			int in = Integer.parseInt(st.nextToken());
			
			cur -= out;
			cur += in;
			
			ans = Math.max(ans, cur);
			
		}
		
		System.out.println(ans);
	}
}
