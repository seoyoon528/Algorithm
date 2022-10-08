package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ17472:다리 만들기2 */
public class BOJ17472 {

	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static LinkedList<Island>[] adjList;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// End Input
		
		// 섬 찾아서 번호로 마킹해주기
		int islandNum = 1;
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					markingIsland(i, j, islandNum);
					islandNum++;
				}
			}
		}
		int totalIslands = islandNum - 1;
		
		adjList = new LinkedList[totalIslands + 1];
		for (int v = 1; v <= totalIslands; v++) {
			adjList[v] = new LinkedList<>();
		}
		
		// 섬에서 다리 놓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= 1) {
					connectBridge(i, j);
				}
			}
		}
		
		// Prim 알고리즘
		boolean[] visited = new boolean[totalIslands + 1];
		int result = 0;
		
		PriorityQueue<Island> pq = new PriorityQueue<Island>();
		pq.add(new Island(1, 0));
		
		int islandCnt = 0;
		while(!pq.isEmpty()) {
			Island minIsland = pq.poll();
			if (visited[minIsland.islandNum]) continue;
			
			result += minIsland.dis;
			visited[minIsland.islandNum] = true;
			islandCnt++;
			
			if (islandCnt == totalIslands) break;
			for (Island island : adjList[minIsland.islandNum]) {
				if (!visited[island.islandNum]) {
					pq.add(island);
				}
			}
		}
		
		if (islandCnt != totalIslands) System.out.println(-1);
		else System.out.println(result);
	}
	
	public static void markingIsland(int y, int x, int num) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		map[y][x] = num;
		visit[y][x] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int newY = p.y + dy[d];
				int newX = p.x + dx[d];
				
				if (newY >= 0 && newY < N && newX >= 0 && newX < M && !visit[newY][newX] && map[newY][newX] == 1) {
					visit[newY][newX] = true;
					map[newY][newX] = num;
					q.add(new Point(newY, newX));
				}
			}
		}
	}

	public static void connectBridge(int y, int x) {		
		for (int d = 0; d < 4; d++) {
			int curY = y;
			int curX = x;
			int dis = 0;
			
			while (true) {
				dis++;
				int newY = curY + dy[d];
				int newX = curX + dx[d];
				
				if (newY < 0 || newY >= N || newX < 0 || newX >= M || map[newY][newX] == map[y][x]) break;
				if (map[newY][newX] != 0) {
					if (dis > 2) {						
						adjList[map[y][x]].add(new Island(map[newY][newX], dis - 1));
						adjList[map[newY][newX]].add(new Island(map[y][x], dis - 1));							
					} 
					break;
				}
				curY = newY;
				curX = newX;
			}
		}
	}
	
	static class Island implements Comparable<Island> {
		int islandNum, dis;

		public Island(int islandNum, int dis) {
			this.islandNum = islandNum;
			this.dis = dis;
		}

		@Override
		public int compareTo(Island o) {
			return this.dis - o.dis;
		}
	}
	
	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
