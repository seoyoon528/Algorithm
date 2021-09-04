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
	
	// DFS
	public static void backtracking(int n, int m, int level) {
		// level = 깊이
		
		if (level == m) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(check[i] == false) { // 해당 노드에 방문하지 않았었다면?
				check[i] = true; // 방문한 상태로 변경
				arr[level] = i + 1; // 배열에 값 저장
				
				backtracking(n, m, level+1);
				check[i] = false; // 자식 노드 방문이 모두 끝나면 다시 방문하지 않은 상태로 변경
			}
		}
			
	}

}
