package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution9229 {
	static int[] snack;
	static boolean[] select;
	static int N, M, max;
	
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
						
			/* for문 연산 ver */
//			for (int i = 0; i < N; i++) {
//				for (int j = i + 1; j < N; j++) {
//					if (snack[i] + snack[j] <= M) {
//						max = Math.max(max, snack[i] + snack[j]);
//					}
//				}
//			}
			
			max = -1;
			/* 조합 ver */
			comb(0, 0);
			comb(0, 0, 0);
			
			System.out.println("#"+test_case+" "+max);

		}
		
	}
	
	// 조합 1 - select[] O
	static void comb(int target, int cnt) {
		if (cnt == 2) {
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if (select[i]) {
					sum += snack[i];
				}
			}
			
			if (sum <= M) {
				max = Math.max(max, sum);	
			}
		}
		if (target == N) return;
		
		select[target] = true;
		comb(target + 1, cnt + 1);
		select[target] = false;
		comb(target + 1, cnt);
	}
	
	// 조합 2 - select[] X
	static void comb(int target, int cnt, int sum) {
		if (cnt == 2) {
			if (sum <= M) {
				max = Math.max(max, sum);	
			}
		}
		if (target == N) return;
		
		comb(target + 1, cnt + 1, sum + snack[target]);
		comb(target + 1, cnt, sum);
	}
}
