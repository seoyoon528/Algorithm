import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {
	
	static int K, W, H, isReach; 
	static int[][] arr, sum;
	static boolean[][][] visit;
	
	static int[] fourdy = {-1, 0, 1, 0};
	static int[] fourdx = {0, 1, 0, -1};

	static int[] eightdy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] eightdx = {-2, -1, 1, 2, -2, -1, 1, 2};
	
	static class Point {
		int y, x;
		int k;
		public Point(int y, int x, int k) {
			this.y = y;
			this.x = x;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		visit = new boolean[H][W][K+1];
		arr = new int[H][W];
		sum = new int[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(sum[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(isReach == 1 ? sum[H - 1][W - 1] : -1);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, K));
		visit[0][0][K] = true;
		sum[0][0] = 0;
		
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				
				if (p.y == H - 1 && p.x == W - 1) {
					isReach = 1;
				}
				
				for (int ed = 0; ed < 8; ed++) {
					int newY = p.y + eightdy[ed];
					int newX = p.x + eightdx[ed];
					
					if (newY >= 0 && newY < H && newX >= 0 && newX < W && arr[newY][newX] == 0) {
						if (p.k > 0 && !visit[newY][newX][p.k - 1] ) {
							sum[newY][newX] = Math.min(sum[newY][newX], cnt);
							
							visit[newY][newX][p.k - 1] = true;
							q.add(new Point(newY, newX, p.k - 1));
						}
					}
				}
				
				for (int fd = 0; fd < 4; fd++) {
					int newY = p.y + fourdy[fd];
					int newX = p.x + fourdx[fd];
					
					if (newY >= 0 && newY < H && newX >= 0 && newX < W && arr[newY][newX] == 0) {
						if (!visit[newY][newX][p.k]) {
							sum[newY][newX] = Math.min(sum[newY][newX], cnt);

							visit[newY][newX][p.k] = true;
							q.add(new Point(newY, newX, p.k));
						}
					}
				}
			}
		}		
	}
}
