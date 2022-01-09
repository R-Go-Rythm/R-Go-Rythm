package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ3460_이진수 {
	static int T, n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			
			n = Integer.parseInt(br.readLine());
			
			List<Integer> list = new ArrayList<>();
			while(true) {
				list.add(n%2);
				n = n/2;
				if(n == 0) break;
			}
			

			for (int i = 0; i < list.size(); i++) {
				if(list.get(i) == 1) sb.append(i).append(" ");
			}
			
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
