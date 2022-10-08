package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* SWEA5643:키 순서 */
public class SWEA5643 {

	static int N;
	static ArrayList<Integer>[] shorter;
	static ArrayList<Integer>[] taller;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			shorter = new ArrayList[N + 1];
			taller = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				shorter[i] = new ArrayList<Integer>();
				taller[i] = new ArrayList<Integer>();
			}
			
			// 키를 입력받아 인접리스트 생성
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// 단방향 연결 
				shorter[b].add(a);
				taller[a].add(b);
			}
			
			// 각 정점을 돌며
			for (int i = 1; i <= N; i++) {
				// 자신보다 작은 학생들 
				boolean[] shortVisit = new boolean[N + 1];
				
				int shortCnt = 0;
				Queue<Integer> sq = new LinkedList<>();
				sq.add(i);
				shortVisit[i] = true;
				
				while (!sq.isEmpty()) {
					int num = sq.poll();
					for (int stu : shorter[num]) {
						if (shortVisit[stu]) continue;
						shortVisit[stu] = true;
						shortCnt++;
						sq.add(stu);
					}
				}
				
				// 자신보다 큰 학생들 
				boolean[] tallVisit = new boolean[N + 1];
				
				int tallCnt = 0;
				Queue<Integer> tq = new LinkedList<>();
				tq.add(i);
				tallVisit[i] = true;
				
				while (!tq.isEmpty()) {
					int num = tq.poll();
					for (int stu : taller[num]) {
						if (tallVisit[stu]) continue;
						tallVisit[stu] = true;
						tallCnt++;
						tq.add(stu);
					}
				}
				if (shortCnt + tallCnt == N - 1) cnt++;
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
