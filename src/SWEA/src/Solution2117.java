package day1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* SWEA2117:홈 방범 서비스 */
public class SWEA2117 {
	
	static int N, M;
	static int[][] map;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// End Input
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, bfs(i, j));
				}
			}
			System.out.println("#"+tc+" " + max);
		}
	}
	
	static int bfs(int i, int j) {
		boolean[][] visit = new boolean[N][N];
		int homeCnt = 0;
		int homeMax = 0;
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		visit[i][j] = true;
		
		int kMax = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			kMax++;
			
			for (int s = 0; s < size; s++) {
				Point cur = q.poll();
				if (map[cur.i][cur.j] == 1) {
					homeCnt++;
				}
				
				for (int d = 0; d < 4; d++) {
					int newi = cur.i + di[d];
					int newj = cur.j + dj[d];
					
					if (0 <= newi && newi < N && 0 <= newj && newj < N && !visit[newi][newj]) {
						visit[newi][newj] = true;
						q.add(new Point(newi, newj));
					}
				}
			}
			// 운영비용 조건 판단
			if (homeCnt * M >= (kMax * kMax + (kMax - 1) * (kMax - 1))) {
				homeMax = Math.max(homeMax, homeCnt);
			}
		}
		return homeMax;
	}
	
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}		
	}
}
