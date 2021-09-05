package baekJoon;

import java.util.Scanner;

public class Test15650 {
	
	public static int[] arr;
	public static int N, M;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		arr = new int[M];
		backtracking(1, 0);
	}
	
	public static void backtracking(int step, int level) {
		if(level == M) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = step; i <= N; i++) {
			arr[level] = i;
			backtracking(i+1, level + 1);
		}
	}

}
