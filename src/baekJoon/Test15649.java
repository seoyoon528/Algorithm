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
		// level = ����
		
		if (level == m) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(check[i] == false) { // �ش� ��忡 �湮���� �ʾҾ��ٸ�?
				check[i] = true; // �湮�� ���·� ����
				arr[level] = i + 1; // �迭�� �� ����
				
				backtracking(n, m, level+1);
				check[i] = false; // �ڽ� ��� �湮�� ��� ������ �ٽ� �湮���� ���� ���·� ����
			}
		}
			
	}

}
