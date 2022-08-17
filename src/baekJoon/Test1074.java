import java.util.Scanner;

/* BOJ1074 - Z문제 */
public class Test1074 {

	static int N, r, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		ans = 0;
		task(0, 0, (1<<N), (1<<N));		// 1<<N :: 거듭제곱
	}

	static int ans;
	static void task(int si, int sj, int ei, int ej) {
		if (!(si <= r && r < ei && sj <= c && c < ej)) {	// 시간 초과 방지용 : 범위 안에 목적지가 없다면 그냥 계산해서 더해주기
			ans += (ei - si) * (ej - sj);
		}
		
		if (ei - si == 1) {
			if (si == r && sj == c) {
				System.out.println(ans);
			}
			ans++;
			return;
		}
		
		int mi = (si + ei) / 2;
		int mj = (sj + ej) / 2;
	
		task(si, sj, mi, mj);	// 1사분면
		task(si, sj, mi, ej);	// 2사분면
		task(mi, sj, ei, mj);	// 3사분면
		task(mi, mj, ei, ej);	// 4사분면
	}
}
