package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1062_가르침 {
	static int N, K, ans;
	static String[] sentence;
	static boolean[] alphabet;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		sentence = new String[N];
		alphabet = new boolean[26];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			sentence[i] = tmp.replace("[a,n,t,i,c]", "");
		}
		// a, n, t, i, c
		if(K<5) System.out.println(0);
		else if(K == 26) System.out.println(N);
		else {
			alphabet[0] = alphabet['n'-'a'] = alphabet['t'-'a'] = alphabet['i'-'a'] = alphabet['c'-'a'] = true;
			find(0, 0);
			System.out.println(ans);
		}
	}
	private static void find(int cnt, int idx) {
		if(cnt == K-5) {
			int tmpCnt = 0;
			// 완전히 사용할 수 있는 문장을 찾는다.
			for (int i = 0; i < N; i++) {
				tmpCnt += checkSentence(sentence[i]);
			}
			// 최대 개수 비교
			ans = Math.max(ans, tmpCnt);
			return;
		}
		
		// 알파벳의 조합을 찾는다
		for (int i = idx; i < 26; i++) {
			if(alphabet[i]) continue;
			alphabet[i] = true;
			find(cnt+1, i);
			alphabet[i] = false;
		}
		
	}
	private static int checkSentence(String s) {
		int size = s.length();
		for (int j = 0; j < size; j++) {
			if(!alphabet[s.charAt(j)-'a']) {
				return 0;
			}
		}
		return 1;
	}
}
