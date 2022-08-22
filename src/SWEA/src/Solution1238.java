import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* SWEA1238 - Contact */
public class SWEA1238 {

	static int L, start, max;
	static boolean[] visited;
	static int[][] arr;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			arr = new int[101][101];
			visited = new boolean[101];
						
			st =  new StringTokenizer(br.readLine());
			for (int i = 0; i < L / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				arr[from][to] = 1;
			}
			System.out.println("#" + test_case + " " + bfs());
		}
	}
	
	public static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			max = 0;

			for (int s = 0; s < size; s++) {
				int cur = q.poll();				
				max = Math.max(max, cur);
				
				for (int i = 1; i < arr[cur].length; i++) {
					if (arr[cur][i] == 1 && !visited[i]) {
						q.offer(i);
						visited[i] = true;
					}
				}
			}
		}
		return max;
	}
}
