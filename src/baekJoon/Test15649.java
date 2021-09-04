package baekJoon;

import java.util.Scanner;

public class Test15649 {

	public static int[] arr;
	public static boolean[] check;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();

		arr = new int[M];
		check = new boolean[N];
		backtracking(N, M, 0);
		
	}
	
	public static void backtracking(int n, int m, int level) {
		
		if (level == m) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			
			System.out.println();
		}
		
		for(int i = 0; i < n; i++) {
			if(check[i] == false) {
				check[i] = true;
				arr[level] = i + 1;
				backtracking(n, m, level+1);
				check[i] = false;
			}
		}
			
	}

}
