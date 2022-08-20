package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test17135 {
	
	static int N, M, D, kill, cnt, maxKill;
	static int[] shoot;
	static int[][] map, copy;
	static int[][] attackOrder;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		if (D > N) D = N;
		
		map = new int[N + 1][M];	// N 번째 줄에는 궁수 위치 
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// End Input

		shoot = new int[3];			// 궁수 뽑기
		archerSet(0, 0);
		System.out.println(maxKill);
	}
	
	public static void archerSet(int cnt, int idx) {
		if (cnt == 3) {
			copy = deepCopy();
			kill = 0;
			
			int turn = 0;
			while(turn < N) {
				if(isEnd()) break;		// 적이 모두 제거되었다면 종료 
				
				attackOrder = new int[3][2];
				int attackCnt = 0;
				
				for (int i = 0; i < 3; i++) { // 궁수 x 좌표
						
					int minDistance = Integer.MAX_VALUE;
					int minY = -1, minX = -1;						
			
					// 공격할 적 고르기
					for (int k = 0; k < M; k++) { // 가장 왼쪽의 적부터 제거 (x 좌표)
						for (int j = N - D; j < N; j++) {  // (y 좌표)
							if (copy[j][k] == 1)  {
								int distance = Math.abs(N - j) + Math.abs(shoot[i] - k);
								if (distance <= D && distance < minDistance) {
									minY = j; minX = k;
									minDistance = distance;
								}	
							}
						}
					}
					// 궁수가 공격할 적의 좌표 저장 
					attackOrder[attackCnt][0] = minY;
					attackOrder[attackCnt][1] = minX;
					attackCnt++;
				}

				for (int i = 0; i < 3; i++) {		// 모든 궁수 동시 공격 
					attack(attackOrder[i][0], attackOrder[i][1]);
				}
				moveEnemy();	// 모든 궁수의 공격이 1번 끝났으면, 적 이동
				turn++;
			}
			
			maxKill = Math.max(maxKill, kill);
			return;
		}

		for (int i = idx; i < M; i++) {
			shoot[cnt] = i;
			archerSet(cnt + 1, i + 1);
		}
	}
	
	public static void attack(int enemyY, int enemyX) {	// 궁수가 적 공격
		if ((enemyY != -1 && enemyX != -1) && copy[enemyY][enemyX] == 1 ) {
			kill++;
			copy[enemyY][enemyX] = 0;
		}	
	}
	
	public static void moveEnemy() {	// 적이 한 칸 아래로 이동
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j] == 1) {
					copy[i][j] = 0;
					
					int newi = i + 1;
					if (newi < N) copy[newi][j] = 1;
				}
			}
		}
	}
	public static int[][] deepCopy() {
		copy = new int[N + 1][M];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}
	
	public static boolean isEnd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 1) return false;
			}
		}
		return true;
	}
}
