package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17144 {
	static class Point {
		int y, x, num;

		public Point(int y, int x, int num) {
			this.y = y;
			this.x = x;
			this.num = num;
		}
	}
	
	static int[] dy = {0, -1, 0, 1};	// 우, 상, 좌, 하
	static int[] dx = {1, 0, -1, 0};
	
	static int[][] map;
	static int R, C, T, acY1, acY2;
	static ArrayList<Point> dusts;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1) {
					acY2 = i;
				}
			}
		}
		// End Input
		
		acY1 = acY2 - 1;
		for (int i = 0; i < T; i++) {
			dusts = new ArrayList<>();
			findDust();
			
			for (int j = 0; j < dusts.size(); j++) {
				 spreadDust(dusts.get(j).y, dusts.get(j).x, dusts.get(j).num);
			}
			airCleaner();
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) result += map[i][j];
			}
		}
		System.out.println(result);		
	}
	
	static void findDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] >= 1) {
					dusts.add(new Point(i, j, map[i][j]));
				}
			}
		}
	}
	
	static void spreadDust(int y, int x, int num) {
		int dust = num;
		int spread = dust / 5;
		int cnt = 0;
		
		for (int d = 0; d < 4; d++) {
			int newY = y + dy[d];
			int newX = x + dx[d];
			
			if (newY < 0 || newY >= R || newX < 0 || newX >= C || map[newY][newX] == -1) continue;
			map[newY][newX] += spread;
			cnt++;
		}
		map[y][x] -= cnt * spread;
	}
	
	static void airCleaner() {		
		// 위 (반 시계 방향)
		for (int i = acY1 - 1; i >= 1; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			map[0][j] = map[0][j + 1];
		}
		for (int i = 0; i < acY1; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int j = C - 1; j >= 2; j--) {
			map[acY1][j] = map[acY1][j - 1];
		}
		map[acY1][1] = 0;

		
		// 아래 (시계 방향)
		for (int i = acY2 + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			map[R - 1][j] = map[R - 1][j + 1];
		}
		for (int i = R - 1; i > acY2; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int j = C - 1; j >= 2; j--) {
			map[acY2][j] = map[acY2][j - 1];
		}
		map[acY2][1] = 0;
	}
}
