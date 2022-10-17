import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* BOJ 15686 - 치킨 배달 */
public class BOJ15686 {
	
	static class Pos {
		int y;
		int x;
		
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static boolean[] chickenSelect;
	static int[][] arr;
	static List<Pos> home, chicken;
	static int homeMin, cityMin, N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] == 1) {
					home.add(new Pos(i, j));
				}
				else if (arr[i][j] == 2) {
					chicken.add(new Pos(i, j));
				}
			}
		}
		
		chickenSelect = new boolean[chicken.size()];
		cityMin = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(cityMin);
	}
	
	public static void comb(int cnt, int start) {
		if (cnt == M) {
			int homeSum = 0;
			
			for (int i = 0; i < home.size(); i++) {
				int dis = 0;
				homeMin = Integer.MAX_VALUE;
				
				for (int j = 0; j < chicken.size(); j++) {
					if (chickenSelect[j]) {
						dis = distance(home.get(i).y, home.get(i).x, chicken.get(j).y, chicken.get(j).x);
						homeMin = Math.min(homeMin, dis);
					}
				}
				homeSum += homeMin;
			}
			cityMin = Math.min(cityMin, homeSum);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			chickenSelect[i] = true;
			comb(cnt + 1, i + 1);
			chickenSelect[i] = false;
		}	
	}
	
	public static int distance(int srcY, int srcX, int destY, int destX) {
		return Math.abs(destY-srcY) + Math.abs(destX-srcX); 
	}
}
