import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* SWEA1249:보급로 */
public class SWEA1249 {

	static int N;
	static int[][] arr, path;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			path = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			for (int i = 0; i < N; i++) {				
				Arrays.fill(path[i], Integer.MAX_VALUE);
			}
			
			bfs();
			System.out.println("#" + test_case + " " + path[N - 1][N - 1]);
		}
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0, 0});
		path[0][0] = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int s = 0; s < size; s++) {
				int[] cur = q.poll();

				for (int d = 0; d < 4; d++) {
					int newY = cur[0] + dy[d];
					int newX = cur[1] + dx[d];
					
					if (newY >= 0 && newY < N && newX >= 0 && newX < N) {
						if (path[cur[0]][cur[1]] + arr[newY][newX] < path[newY][newX]) {
							path[newY][newX] = path[cur[0]][cur[1]] + arr[newY][newX];
							q.add(new int[] {newY, newX});
						}
					}
				}
			}
		}
	}
}
