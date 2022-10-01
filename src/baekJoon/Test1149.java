import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 1149 : RGB 거리 */
public class Test1149 {

	static int N;
	static int[][] memo, arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		memo = new int[N][3];
		arr = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		memo[0][0] = arr[0][0];
		memo[0][1] = arr[0][1];
		memo[0][2] = arr[0][2];
		
		for (int i = 1; i < N; i++) {
			memo[i][0] = arr[i][0] + Math.min(memo[i-1][1], memo[i-1][2]);
			memo[i][1] = arr[i][1] + Math.min(memo[i-1][0], memo[i-1][2]);
			memo[i][2] = arr[i][2] + Math.min(memo[i-1][0], memo[i-1][1]);
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (memo[N-1][i] < min) {
				min = memo[N-1][i];
			}
		}

		System.out.println(min);
	}
}
