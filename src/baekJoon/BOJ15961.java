import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ15961:회전초밥 */
public class BOJ15961 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 초밥 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken());	// 초밥 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
	
		int[] visit = new int[d + 1];		
		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int startIdx = 0, endIdx = 0, count = 0, cnt = 0, max = 0;
		
		while (endIdx < N + k) {
			if (count == k) {
				if (cnt >= max) {
					max = cnt;
					if (visit[c] == 0) max++;
				}

				if (max == k + 1) break;
				
				visit[sushi[startIdx % N]]--;
				if (visit[sushi[startIdx % N]] == 0) cnt--;
				startIdx++;
				count--;
			}
			
			int cur = sushi[endIdx % N];
			if (visit[cur] == 0) cnt++;
			visit[cur]++;
			count++;
			endIdx++;
		}
		System.out.println(max);
	}
}
