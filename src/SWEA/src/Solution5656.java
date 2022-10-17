import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* SWEA5656:벽돌 깨기 */
public class Solution5656 {

	static int N, W, H, minBricks;
	static int[][] map, copy;
	static int[] ballsOrder;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			ballsOrder = new int[N];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// End Input
			
			minBricks = Integer.MAX_VALUE;
			setPosition(0);
			
			System.out.println("#"+tc+" "+minBricks);
		}
	}
	
	// 1. 구슬을 떨어뜨릴 위치 정하기
	//	  중복 순열 사용
	public static void setPosition(int cnt) {
		if (cnt == N) {
			copy = copyMap(map);
			
			for (int i = 0; i < N; i++) {
				dropBall(ballsOrder[i]);				
			}

			minBricks = Math.min(minBricks, countBricks());
			return;
		}
		
		for (int i = 0; i < W; i++) {
			// 뽑기
			ballsOrder[cnt] = i;
			// 다음으로 구슬을 떨어뜨릴 위치 선정
			setPosition(cnt + 1);
		}	
	}
	
	// 2. 구슬 떨어뜨리기
	//	  map[i][j]가 0이 아닌 곳 까지 전진	
	public static void dropBall(int x) {
		int idx = 0;
		while(copy[idx][x] == 0) {
			idx++;
			if (idx == H - 1) break;
		}
		breakBricks(idx, x);
	}
	
	// 3. 벽돌 깨기 -> 구슬이 명중한 벽돌은 상하좌우로 ( 벽돌에 적힌 숫자 - 1 ) 칸 만큼 같이 제거된다.
	//	  깨지는 벽돌이 (map[i][j]) 1보다 크다면 Queue에 추가
	public static void breakBricks(int y, int x) {		
		Queue<Point> q = new ArrayDeque<Point>();
		q.add(new Point(y, x, copy[y][x]));
		copy[y][x] = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nowi = cur.i;
				int nowj = cur.j;
				
				for (int i = 0; i < cur.num - 1; i++) {
					nowi += di[d];
					nowj += dj[d];
					
					if (nowi < 0 || nowi >= H || nowj < 0 || nowj >= W || copy[nowi][nowj] == 0) continue;
					if (copy[nowi][nowj] > 1) {
						q.add(new Point(nowi, nowj, copy[nowi][nowj]));						
					}
					copy[nowi][nowj] = 0;
				}
			}
		}
		downBricks();
	}
	
	// 4. 안깨진 벽돌 내려주기
	public static void downBricks() {
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {
				
				if (copy[j][i] >= 1) {
					int temp = copy[j][i];
					int height = j;
					
					while (true) {
						if (height == H - 1) {
							break;
						}
						if (copy[height + 1][i] >= 1) break;
						height++;
					}
					copy[j][i] = 0;
					copy[height][i] = temp;
				}
			}
		}
	}
	
	public static int countBricks() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copy[i][j] >= 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static int[][] copyMap(int[][] arr) {
		int[][] copy = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
	
	static class Point {
		int i, j;
		int num;

		public Point(int i, int j, int num) {
			this.i = i;
			this.j = j;
			this.num = num;
		}
	}
}
