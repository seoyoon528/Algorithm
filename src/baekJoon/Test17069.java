import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 17069 : 파이프 옮기기2 */
public class Test17069 {
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// End Input
		dp();
	}
	
	static void dp() {
		long[][][] memo = new long[N + 1][N + 1][3];
		memo[1][2][0] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				
				// 가로
				if (arr[i][j] == 0) {
					memo[i][j][0] = memo[i][j - 1][0] + memo[i][j - 1][1];
				}
				
				// 대각선
				if (i > 1 && arr[i][j] == 0 && arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
					memo[i][j][1] = memo[i - 1][j - 1][0] + memo[i - 1][j - 1][1] + memo[i - 1][j - 1][2];
				}
				
				// 세로
				if (arr[i][j] == 0) {
					memo[i][j][2] = memo[i - 1][j][1] + memo[i - 1][j][2];
				}
				
			}
		}	
		System.out.println(memo[N][N][0] + memo[N][N][1] + memo[N][N][2]);
	}
}
