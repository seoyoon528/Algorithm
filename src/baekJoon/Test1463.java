import java.util.Arrays;
import java.util.Scanner;

/* BOJ 1463 : 1로 만들기 */
public class Test1463 {

	static int N;
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		memo = new int[N + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 0;
		memo[1] = 0;
		
		if (N == 1) {
			System.out.println(0);
			return; 
		}
		else {
			dp(2);
		}
	}
	
	public static void dp(int n) {
		if (n == N+1) {
			System.out.println(memo[N]);
			return; 
		}
		
		memo[n] = memo[n - 1] + 1;
		
		if (n % 3 == 0) {
			memo[n] = Math.min(memo[n], memo[n / 3] + 1);
		}
		
		if (n % 2 == 0) {
			memo[n] = Math.min(memo[n], memo[n / 2] + 1);
		}
		dp(n + 1);				
	}
}
