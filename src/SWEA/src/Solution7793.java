package day1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* SWEA7793:오! 나의 여신님 */
public class SWEA7793 {
	
	static int N, M;
	static char[][] map;
	static Point suyeon;
	static ArrayList<Point> devil;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			
			devil = new ArrayList<Point>();
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*') {
						devil.add(new Point(i, j));
					}
					else if (map[i][j] == 'S') {
						suyeon = new Point(i, j);
					}
				}
			}
			// End Input
			int ans = suyeonMove();
			System.out.println("#"+tc+" " + (ans == -1 ? "GAME OVER" : ans));
		}
	}
	
	
	static int suyeonMove() {
		boolean[][] suyeonVisit = new boolean[N][M];
		Queue<Point> suyeonQueue = new LinkedList<Point>();
		suyeonQueue.add(suyeon);
		suyeonVisit[suyeon.y][suyeon.x] = true;
		
		int time = 0;
		while (!suyeonQueue.isEmpty()) {
			
			// 악마 이동
			int devilSize = devil.size();
			
			for (int i = 0; i < devilSize; i++) {
				Point cur = devil.get(i);
				
				for (int d = 0; d < 4; d++) {
					int newi = cur.y + di[d];
					int newj = cur.x + dj[d];
					
					if (newi >= 0 && newi < N && newj >= 0 && newj < M && map[newi][newj] != 'X' && map[newi][newj] != 'D' && map[newi][newj] != '*') {
						map[newi][newj] = '*';
						devil.add(new Point(newi, newj));
					}
				}
			}
			
			int size = suyeonQueue.size();
			for (int s = 0; s < size; s++) {
				
				// 수연 이동
				Point curSuyeon = suyeonQueue.poll();
				
				if (map[curSuyeon.y][curSuyeon.x] == 'D') {
					return time;
				}
				
				for (int d = 0; d < 4; d++) {
					int newi = curSuyeon.y + di[d];
					int newj = curSuyeon.x + dj[d];
					
					if (newi >= 0 && newi < N && newj >= 0 && newj < M && !suyeonVisit[newi][newj] && map[newi][newj] != 'X' && map[newi][newj] != '*') {
						suyeonVisit[newi][newj] = true;
						suyeonQueue.add(new Point(newi, newj));
					}
				}
				
			}
			time++;
		}
		return -1;
	}
	
	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}		
	}
}
