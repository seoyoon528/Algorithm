package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9663 {	// N-Queen (Backtracking)
	
	public static int N;
	public static int count;
	
	public static int[][] chessBoard;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		chessBoard = new int[N][N];
		visit = new boolean[N][N];
		
		NQueen(0);
	}
	
	public static void NQueen(int row) {
		if(row == N) {
			System.out.println(count);
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
	 			if(visit[i][j] == false) {
	 			}

			}
		}
	}

}
