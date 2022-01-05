package part1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309_일곱난쟁이 {
	static int[] list;
	static int total;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new int[9];
		total = 0;
		for (int i = 0; i < 9; i++) {
			list[i] = Integer.parseInt(br.readLine());
			total += list[i];
		}
		
		find();

		Arrays.sort(list);
		
		for (int i = 2; i < 9; i++) {
			System.out.println(list[i]);
		}
		
	}
	private static void find() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(i == j) continue;
				if(total - list[i] - list[j] == 100) {
					list[i] = 0;
					list[j] = 0;
					return;
				}
			}
		}	
	}
}
