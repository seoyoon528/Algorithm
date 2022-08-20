import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1247 {
	
	static class Node {
		int y;
		int x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int[] order;
	static boolean[] visited;
	static int N, minDistance;
	static Node[] route;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			route = new Node[N + 2];
			route[0] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	// company
			route[N + 1] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	// home
			
			for (int i = 1; i <= N; i++) {
				route[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
			}
			// End Input
			
			order = new int[N + 2];
			visited = new boolean[N + 1];
			minDistance = Integer.MAX_VALUE;
			
			perm(1);
			System.out.println("#"+test_case+" "+minDistance);
		}
	}
	
	public static void perm(int idx) {
		if (idx == N + 1) {
			int distance = 0;
			
			for (int i = 1; i <= N + 1; i++) {
				distance += (Math.abs(route[order[i]].x - route[order[i-1]].x) +  Math.abs(route[order[i]].y - route[order[i-1]].y));
			}
			
			minDistance = Math.min(minDistance, distance);
			return;
		}
		
		order[0] = 0;
		order[N+1] = N+1;
		
		for (int i = 1; i <= N; i++) { 
			if (visited[i]) continue;
			
			order[idx] = i;
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

}
