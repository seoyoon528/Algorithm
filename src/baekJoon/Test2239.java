import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2239_스도쿠_교수님 {

	static int[][] sdoku;
	static ArrayList<Point> emptyList;
	static boolean isComplete;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sdoku = new int[10][10];
		emptyList = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = str.charAt(j) - '0';
				if (sdoku[i][j] == 0) {
					emptyList.add(new Point(i, j));
				}
			}
		}
		
		dfs(0);
		
	}
	
	static void dfs(int idx) {	// 채워야 하는 빈칸
		if (idx == emptyList.size()) {	// 모든 빈 칸을 다 채운 경우 -> 종료~
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sdoku[i][j]);
				}
				System.out.println();
			}
			
			// 스도쿠가 완성되었을 때 종료시키지 않으면 값이 더 큰 수로 갱신됌
			isComplete = true;
			return;
		}
		
		Point now = emptyList.get(idx);	// 내가 채워야 하는 빈 칸의 좌표
		for (int num = 1; num <= 9; num++) {
			if (check(now.y, now.x, num)) {	// i (1~9)를 현재 자리에 써도 되는지 안되는지 스도쿠 규칙 체크
				sdoku[now.y][now.x] = num;
				dfs(idx + 1);	// 다음 빈 칸은 후배에게 맡기고 난 기다려
				if (isComplete) return;
			}
		}
		
		sdoku[now.y][now.x] = 0;	// 백트래킹. 돌려놓지 않으면 다른 애들이 쓰지 못해
		return;
	}
	
	static boolean check (int nowi, int nowj, int num) {	// i, j 자리에 num 들어와도 되는지
		for (int i = 0; i < 9; i++) {
			if (sdoku[i][nowj] == num) return false;	// 현재 nowj 열 고정으로 행만 움직여서 같은 숫자 있는지 확인
		}
		for (int j = 0; j < 9; j++) {
			if (sdoku[nowi][j] == num) return false;
		}
		int si = nowi / 3 * 3;
		int sj = nowj / 3 * 3;
		
		for (int i = si; i < si + 3; i++) {
			for (int j = sj; j < sj + 3; j++) {
				if (sdoku[i][j] == num) return false;
			}
		}
		return true;
	}
	
	static class Point {
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}
	}
}
