package day1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* SWEA1767:프로세서 연결하기 */
public class SWEA1767 {

	static int N, maxCore, minWire;
	static int[][] map;
	static ArrayList<Point> coreList;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<Point>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {

						// 전원에 붙어있는 코어들 빼고 넣어주기
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							continue;
						}
						coreList.add(new Point(i, j));
					}
				}
			}
			// End Input
			
			// 부분집합으로 한개 놓는 경우부터 돌려보기
			maxCore = -1;
			minWire = Integer.MAX_VALUE;
			
			subset(0, 0, 0);
			System.out.println("#" + tc +" " + minWire);
		}
	}
	
	public static void subset(int idx, int coreCnt, int wireCnt) {
		if (idx == coreList.size()) {
			// 최대 코어인지 확인
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minWire = wireCnt;
			}
			else if (coreCnt == maxCore) {
				// 최대 코어라면 최소 전선인지 확인
				minWire = Math.min(minWire, wireCnt);				
			}
			return;
		}
		
		Point cur = coreList.get(idx);

		for (int d = 0; d < 4; d++) {
			int nowi = cur.i;
			int nowj = cur.j;
			int dis = 0;
			boolean flag = false;
			
			while (true) {
				int newi = nowi + di[d];
				int newj = nowj + dj[d];
				
				if (newi < 0 || newi >= N || newj < 0 || newj >= N) {
					flag = true;
					break;
				}
				if (map[newi][newj] == 1) break;
		
				nowi = newi;
				nowj = newj;
				dis++;
			}
			
			nowi = cur.i;
			nowj = cur.j;
			
			// 전선을 놓을 수 있다면 전선 놓기
			if (flag) {
				for (int i = 0; i < dis; i++) {
					nowi += di[d];
					nowj += dj[d];
					map[nowi][nowj] = 1;
				}
				subset(idx + 1, coreCnt + 1, wireCnt + dis);
				
				nowi = cur.i;
				nowj = cur.j;
				for (int i = 0; i < dis; i++) {
					nowi += di[d];
					nowj += dj[d];
					map[nowi][nowj] = 0;
				}
			}
			else {
				// 안뽑기
				subset(idx + 1, coreCnt, wireCnt);
			}
		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
