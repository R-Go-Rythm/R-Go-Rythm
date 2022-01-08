package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1292_쉽게푸는문제 {
	static int A, B, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> list = new ArrayList<>();
		int num = 1;
		int cnt = 0;
		for (int i = 1; i <= 1000; i++) {
			list.add(num);
			if(++cnt == num) {
				num++;
				cnt = 0;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		for (int i = A-1; i < B; i++) {
			ans += list.get(i);
		}
		System.out.println(ans);
	}
}
