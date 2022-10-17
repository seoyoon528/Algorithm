import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* SWEA1949:등산로 조성 */
public class Solution1949 {

	static int N, K, maxHeight, maxLength;
	static int[][] map;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			maxHeight = 0;
			maxLength = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			// End Input
			
			// 1. 가장 높은 봉우리들을 찾아서 DFS 시작!
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxHeight) {
						boolean[][] visit = new boolean[N][N];
						DFS(i, j, 1, false, visit);
					}
				}
			}
			System.out.println("#"+tc+" "+ maxLength);
		}
	}

	public static void DFS(int i, int j, int length, boolean flag, boolean[][] visit) {
		visit[i][j] = true;
			
		for (int d = 0; d < 4; d++) {
			int newi = i + di[d];
			int newj = j + dj[d];
			
			if (newi < 0 || newi >= N || newj < 0 || newj >= N || visit[newi][newj]) continue;
			
			if (map[newi][newj] < map[i][j]) {
				DFS(newi, newj, length + 1, flag, visit);
				visit[newi][newj] = false;
			}
			else if (map[newi][newj] - K < map[i][j] && flag == false) {
				flag = true;
				int origin = map[newi][newj];
				map[newi][newj] = map[i][j] - 1;
				
				DFS(newi, newj, length + 1, flag, visit);
				
				flag = false;
				map[newi][newj] = origin;
				visit[newi][newj] = false;
			}
		}
		// 4방을 다 봐도 더 이상 갈 곳이 없다면 return
		maxLength = Math.max(maxLength, length);
		return;
	}
	
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
