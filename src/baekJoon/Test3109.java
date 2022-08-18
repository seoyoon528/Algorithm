import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3109 {

	static int[] dy = {-1, 0, 1};	// /, -, \ :: 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선 
	static int[] dx = {1, 1, 1};
	
	static int R, C, cnt;
	static char[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			pipeLine(i, 0, 0);
		}
		System.out.println(cnt);
	}
	
	public static boolean pipeLine(int y, int x, int col) {
		if (col == C - 1) {
			cnt++;
			return true;
		}
						
		for (int d = 0; d < 3; d++) {
			int newY = y + dy[d];
			int newX = x + dx[d];
			
			if (newY < 0 || newY >= R || newX < 0 || newX >= C || arr[newY][newX] == 'x' || visited[newY][newX]) continue;

			visited[newY][newX] = true;
			if (pipeLine(newY, newX, col + 1)) return true;
		}
		return false;
	}

}
