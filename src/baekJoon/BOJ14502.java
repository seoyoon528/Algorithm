import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}		
	}
	
	static int N, M, max;
	static int[][] map, copy;
	static boolean[][] block;
	static Point[] wall;
	static ArrayList<Point> virus, empty;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		block = new boolean[N][M];
		
		virus = new ArrayList<Point>();
		empty = new ArrayList<Point>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 2) virus.add(new Point(i, j));
				else if (map[i][j] == 0) empty.add(new Point(i, j));
			}
		}
		// End Input
		
		comb(0, 0);
		System.out.println(max);
	}
	
	public static void comb(int cnt, int start) {
		if (cnt == 3) {
			
			copy = copyMap();
			for (int i = 0; i < empty.size(); i++) {
				if (block[empty.get(i).y][empty.get(i).x]) {
					copy[empty.get(i).y][empty.get(i).x] = 1;
				}
			}
			
			spreadVirus();
			max = Math.max(max, countSafeArea());
			
			return;
		}
		
		for (int i = start; i < empty.size(); i++) {
			block[empty.get(i).y][empty.get(i).x] = true;
			comb(cnt + 1, i + 1);	
			block[empty.get(i).y][empty.get(i).x] = false;
		}
	}
	
	public static int[][] copyMap() {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}
	
	
	public static void spreadVirus() {
		Queue<Point> q = new LinkedList<Point>();
		
		for (int i = 0; i < virus.size(); i++) {			
			q.add(virus.get(i));
		}
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int newY = cur.y + dy[d];
				int newX = cur.x + dx[d];
				
				if (newY >= 0 && newY < N && newX >= 0 && newX < M && copy[newY][newX] == 0) {
					copy[newY][newX] = 2;
					q.add(new Point(newY, newX));
				}
			}
		}
	}
	
	public static int countSafeArea() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
