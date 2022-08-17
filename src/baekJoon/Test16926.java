import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test16926 {
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] arr;
	static int N, M, R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// End Input
		
		for (int i = 0; i < R; i++) {
			rotation();	
		} 
		
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	
	public static void rotation() {
		int level = Math.min(N, M) / 2;
		
		for (int l = 0; l < level; l++) {
			int y = l;
			int x = l;
			int tmp = arr[l][l];
			int d = 0;
			
			while (true) {
				int newY = y + dy[d];
				int newX = x + dx[d];
				
				if (newY < l || newY >= N - l || newX < l || newX >= M - l) {
					d = (d + 1) % 4;
					newY = y + dy[d];
					newX = x + dx[d];
				}

				if (newY == l && newX == l) {
					arr[newY][newX] = tmp;
					break;
				}
				
				int next = arr[newY][newX];
				arr[newY][newX] = tmp;
				tmp = next;
				y = newY;
				x = newX;
			
			}
		}
	}

}
