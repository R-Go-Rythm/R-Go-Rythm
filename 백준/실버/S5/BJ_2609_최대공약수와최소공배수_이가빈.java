package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609_최대공약수와최소공배수 {
	static int gcd, lcm;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(a<b) {
			gcd = gcd(b, a);
		} else {
			gcd = gcd(a, b);
		}
		
		lcm = a*b/gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
	}

	private static int gcd(int a, int b) {
		while(b != 0) {
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
