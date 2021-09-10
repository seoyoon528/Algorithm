package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9663 {	// N-Queen (Backtracking)
	
	public static int N;
	public static int count;
	
	public static int[] chessBoard;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		chessBoard = new int[N];
		
		NQueen(0);
		System.out.println(count);
	}
	
	public static void NQueen(int col) { // 1��° ��->N��° �� ������ �����ϸ� queen check
		if(col == N) {
			count++;
			return;
		}
		
		else {
			for(int i = 0; i < N; i++) {
				chessBoard[col] = i;
				
				if (possible(col) == true) { // �ش� ���� i��° �࿡ queen�� ���� ���� �������� check
					NQueen(col+1);
				}
			}
		}
		
	}

	public static boolean possible(int col) {
		
		for(int i = 0; i < col; i++) {
			if(chessBoard[col] == chessBoard[i]) { // ���� �࿡ �̹� queen�� �����ϴ� ���
				return false;
			}
			
			// �밢���� �̹� queen�� �����ϴ� ���
			else if (Math.abs(col - i) == Math.abs(chessBoard[col] - chessBoard[i])) {
				return false;
			}
		}
		
		return true;
	}

}
