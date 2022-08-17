import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test16935 {
	static int N, M, tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] order = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < R; i++) {
			arr = arrFunc(order[i], arr);	
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] arrFunc(int code, int[][] arr) {
		switch(code) { 
		
		// 1번 연산 :: 상하 반전
		case 1:
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N/2; j++) {
					int tmp = arr[j][i];
					arr[j][i] = arr[N-j-1][i];
					arr[N-j-1][i] = tmp;
				}
			}
			return arr;
		
			
		// 2번 연산 :: 좌우 반전
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					int tmp = arr[i][j];
					arr[i][j] = arr[i][M-j-1];
					arr[i][M-j-1] = tmp;
				}
			}
			return arr;
		
		
		// 3번 연산 :: 오른쪽 90도 회전
		case 3:
			int[][] turnRight = new int[M][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					turnRight[j][N-i-1] = arr[i][j];
				}
			}
			
			tmp = N;
			N = M;
			M = tmp;
			return turnRight;
			
			
		// 4번  연산 :: 왼쪽 90도 회전
		case 4:
			int[][] turnLeft = new int[M][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					turnLeft[M-j-1][i] = arr[i][j];
				}
			}
			
			tmp = N;
			N = M;
			M = tmp;
			return turnLeft;
		
		// 5번  연산 :: 시계방향 회전
		case 5:
			int[][] turnClock = new int[N][M];
			// 1 -> 2
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					turnClock[i][M/2 + j] = arr[i][j];
				}
			}
			
			// 2 -> 3
			for (int i = 0; i < N/2; i++) {
				for (int j = M/2; j < M; j++) {
					turnClock[N/2 + i][j] = arr[i][j];
				}
			}
			
			// 3 -> 4
			for (int i = N/2; i < N; i++) {
				for (int j = M/2; j < M; j++) {
					turnClock[i][j - M/2] = arr[i][j];
				}
			}
			
			// 4 -> 1
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					turnClock[i - N/2][j] = arr[i][j];
				}
			}
			return turnClock;
			
		// 6번  연산 :: 반시계방향 회전
		case 6:
			for (int i = 0; i < 3; i++) {
				arr = arrFunc(5, arr);	
			}
			return arr;
		}
		return arr;
	}

}
