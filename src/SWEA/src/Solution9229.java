package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution9229 {
	static int[] snack;
	static int N, M;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
						
			max = -1;
			selectSnack(0, 0, 0);
			
			if (max == -1) {
				max = -1;
			}
			
			System.out.println("#"+test_case+" "+max);

		}
		
	}
	public static void selectSnack(int weight, int idx, int cnt) {
		if (cnt == 2) {
			if (weight <= M) {
				max = Math.max(max, weight);
			}
			return;
		}
		if (idx == N) return;
		
		
		selectSnack(weight + snack[idx], idx + 1, cnt + 1);
		selectSnack(weight, idx + 1, cnt);
	} 

}
