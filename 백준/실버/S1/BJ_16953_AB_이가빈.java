package DFSnBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953_AB {
	static int a, b, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		find();
		
		System.out.println(ans);
	}
	// b에서 a를 찾아가는 방식으로
	private static void find() {
		int cnt = 1;
		
		while(a != b) {
			if(a>b) {
				ans = -1;
				return;
			}
			
			
			if(b%10 == 1) { // 일의 자리가 1이면 없앤다
				b = b/10;
			} else if (b%2 == 0){ // 2로 나눠지면 나눈다. 
				b = b/2;
			} else { // 위의 경우에 걸리지 않는다면 변경 불가
				ans = -1;
				return;
			}
			
			cnt++;
		}
		
		ans = cnt;
		
	}
}
