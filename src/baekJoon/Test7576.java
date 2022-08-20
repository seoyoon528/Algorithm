import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/* BOJ7576 - 토마토 */
public class BOJ7576 {

	static class Node {
		int y;
		int x;
		int cnt;
		
		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	static int N, M, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static Deque<Node> dq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] == 1) {
					dq.offer(new Node(i, j, cnt + 1));
					visited[i][j] = true;
				}
			}
		}
		// End Input
		
		if (allRipe()) {
			System.out.println(0);
			return;
		}
		
		bfs();
	}
	
	public static void bfs() {
		int totalCnt = 0;
		
		while (!dq.isEmpty()) {
			Node node = dq.poll();
			
			for (int d = 0; d < 4; d++) {
				int newY = node.y + dy[d];
				int newX = node.x + dx[d];
				
				if (newY < 0 || newY >= N || newX < 0 || newX >= M || arr[newY][newX] == -1 || visited[newY][newX]) continue;
				
				if (arr[newY][newX] == 0) {
					arr[newY][newX] = 1;
					visited[newY][newX] = true;
					dq.offer(new Node(newY, newX, node.cnt + 1));
					
					if (node.cnt > totalCnt) {
						totalCnt = node.cnt;
					}
				}
			}
		}
		
		if (allRipe()) System.out.println(totalCnt);
		else System.out.println(-1);
		return;
	}
	
	public static boolean allRipe() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
