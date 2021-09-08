package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test15652 {
	
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		backtracking(N, M, 0);
		
		System.out.print(sb);
	}
	
	public static void backtracking(int n, int m, int level) {
		if(level == m) {
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
		} 
		else {
			for(int i = 1; i <= n; i++) {
				if(level == 0 || i >= arr[level-1]) {
					arr[level] = i;
					backtracking(n, m, level+1);
				}
				
			}
		}
	}

}
