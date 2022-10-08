package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471 {

	static int N, min;
	static int[] popul;
	static boolean[] select;
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		popul = new int[N + 1];
		select = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int area = Integer.parseInt(st.nextToken());
				adjList[i].add(area);
			}
		}
		// End Input

		min = Integer.MAX_VALUE;
		powerSet(1);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void powerSet(int idx) {
		if (idx == N + 1) {
			ArrayList<Integer> area1 = new ArrayList<>();
			ArrayList<Integer> area2 = new ArrayList<>();
			int selectCnt = 0, unSelectCnt = 0;

			for (int i = 1; i <= N; i++) {
				if (select[i]) {
					area1.add(i);
					selectCnt += popul[i];
				}
				else {
					area2.add(i);
					unSelectCnt += popul[i];
				}
			}
			
			// 다 뽑았으면 연결되어있나 확인하기
			if (area1.size() != 0 && area2.size() != 0 && isConnected(area1) && isConnected(area2)) {
				// 연결되어있다면 두 지역 인구의 차이 구하기
				min = Math.min(min, Math.abs(selectCnt - unSelectCnt));
			}
			return;
		}
		
		// 가능한 지역구 부분집합으로 뽑기
		select[idx] = true;
		powerSet(idx + 1);
		select[idx] = false;
		powerSet(idx + 1);
	}
	
	static boolean isConnected(ArrayList<Integer> arr) {
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(arr.get(0));
		visit[arr.get(0)] = true;
		
		while(!q.isEmpty()) { 
			int num = q.poll();
			
			for (int area : adjList[num]) {
				if (visit[area] || !arr.contains(area)) continue;
				visit[area] = true;
				q.add(area);
			}
		}
		
		for (int i = 0; i < arr.size(); i++) {
			if (!visit[arr.get(i)]) {
				return false;
			}
		}
		return true;
	}
}
