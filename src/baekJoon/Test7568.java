package baekJoon;

import java.util.Scanner;

public class Test7568 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] arr = new int[N][2];
		int[] rank = new int[N];
				
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = scan.nextInt();
			}	
		}

		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if (i != j) {
					if (arr[i][0] < arr[j][0]) {
						if (arr[i][1] < arr[j][1]) {
							rank[i]++;
						}
					}	
				}
				
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print((rank[i]+1) + " ");
		}

	}

}
