package baekJoon;

import java.util.Scanner;

public class Test15650 {	// 다시 풀어보기
	public static int[] arr;
	public static boolean[] check;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		arr = new int[M];
		check = new boolean[N+1];
		backtracking(N, M, 0);
	}
	
	public static void backtracking(int n, int m, int level) {
		if(level == m) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			
			System.out.println();			
		} else {
			for(int i = 1; i <= n; i++) {
				if(check[i] == false) {
					if(level == 0 || i > arr[level - 1]) {
						check[i] = true; 
						arr[level] = i; 
					
						backtracking(n, m, level+1);
						check[i] = false; 
					}
					
				}
			}	
		}
		
	}

}
