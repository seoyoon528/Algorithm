package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA4014:활주로 건설 */
public class SWEA4014 {

	static int N, X;
	static int[][] map;
	
	// true => 경사로 불가능,  false => 경사로 가능
	static boolean[] garo;	
	static boolean[] sero;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// End Input
			
			garo = new boolean[N];
			sero = new boolean[N];
			
			// 가로줄
			for (int i = 0; i < N; i++) {
				boolean[] visit = new boolean[N];

				// 왼 -> 오  
				int xCnt = 0;
				boolean lflag = false;	// 경사로 가능
				
				int beforeMax = map[i][0];
				for (int j = 1; j < N; j++) {
					if (beforeMax - map[i][j] > 1) {
						garo[i] = true;	// 경사로 불가능
						break;
					}			
					if (beforeMax - map[i][j] == 1) {
						if (xCnt == 0) lflag = true;	// 경사로 불가능
						if (!visit[j]) {
							xCnt++;
							visit[j] = true;					
							
							if (xCnt == X) {
								xCnt = 0;
								beforeMax = beforeMax - 1;
								lflag = false; // 경사로 가능
							}
						} else break;
					}
					if (!lflag && beforeMax < map[i][j]) beforeMax = map[i][j];
				}
				if (lflag) garo[i] = true;
								
				// 왼 <- 오
				xCnt = 0;
				boolean rflag = false;	// 경사로 가능
				
				beforeMax = map[i][N - 1];
				for (int j = N - 2; j >= 0; j--) {
					if (beforeMax - map[i][j] > 1) {
						garo[i] = true;	// 경사로 불가능
						break;
					}
					if (beforeMax - map[i][j] == 1) {
						if (xCnt == 0) rflag = true;	// 경사로 불가능
						if (!visit[j]) {
							xCnt++;
							visit[j] = true;							
							
							if (xCnt == X) {
								xCnt = 0;
								beforeMax = beforeMax - 1;
								rflag = false; // 경사로 가능
							}
						} else break;
					}
					if (!rflag && beforeMax < map[i][j]) {
						beforeMax = map[i][j];
					}
				}
				if (rflag) garo[i] = true;
			}
			
			//세로
			for (int i = 0; i < N; i++) {
				boolean[] visit = new boolean[N];

				// 위 -> 아래   
				int xCnt = 0;
				boolean uflag = false;	// 경사로 가능
				
				int beforeMax = map[0][i];
				for (int j = 1; j < N; j++) {
					if (beforeMax - map[j][i] > 1) {
						sero[i] = true;	// 경사로 불가능
						break;
					}					
					if (beforeMax - map[j][i] == 1) {
						if (xCnt == 0) uflag = true;	// 경사로 불가능
						if (!visit[j]) {
							xCnt++;
							
							if (xCnt == X) {
								xCnt = 0;
								beforeMax = beforeMax - 1;
								uflag = false; // 경사로 가능
							}
							visit[j] = true;							
						} else break;
					}
					if (!uflag && beforeMax < map[j][i]) beforeMax = map[j][i];
				}
				if (uflag) sero[i] = true;
				
				// 위 <- 아래
				xCnt = 0;
				boolean dflag = false;	// 경사로 가능

				beforeMax = map[N - 1][i];
				for (int j = N - 2; j >= 0; j--) {
					if (beforeMax - map[j][i] > 1) {
						sero[i] = true;	// 경사로 불가능
						break;
					}
					if (beforeMax - map[j][i] == 1) {
						if (xCnt == 0) dflag = true;	// 경사로 불가능
						if (!visit[j]) {
							xCnt++;
							
							if (xCnt == X) {
								xCnt = 0;
								beforeMax = beforeMax - 1;
								dflag = false; // 경사로 가능
							}
							visit[j] = true;							
						} else break;
					}
					if (!dflag && beforeMax < map[j][i]) beforeMax = map[j][i];
				}
				if (dflag) sero[i] = true;					
			}

			// 활주로를 건설할 수 있는 경우 세어주기
			int ans = 0;
			for	(int i = 0; i < N; i++) {
				if (!garo[i]) ans++;
				if (!sero[i]) ans++;
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
}
