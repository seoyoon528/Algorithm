import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1192 {

	static int[][] arr;
	static int N;
	static StringBuilder str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		str = new StringBuilder();
		quad(0, 0, N);
		System.out.println(str);
	}
	
	public static void quad(int y, int x, int N) {
		if (check(y, x, N)) {
			str.append(arr[y][x]);
			return;
		}
		else {
			str.append("(");
		}
		
		quad(y, x, N / 2);
		quad(y, x + N / 2, N / 2);
		quad(y + N / 2, x, N / 2);
		quad(y + N / 2, x + N / 2, N / 2);
		str.append(")");

	}
	
	public static boolean check(int y, int x, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (arr[i][j] != arr[y][x]) {
					return false;
				} 
			}
		}
		return true;
	}
}
