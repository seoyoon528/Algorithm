import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 정사각형 방 - 재귀 버전 */
public class Solution1681Recur {
 
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
     
    static int[][] arr;
    static boolean[][] visited;
    static int N, cnt;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            int max = -1;
            int maxIdx = N*N+1;
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                     
                    dfs(i, j);
                     
                    if (cnt > max) {
                        max = cnt;
                        maxIdx = arr[i][j];
                    }
                    else if (cnt == max) {
                        if (arr[i][j] < maxIdx) {
                            maxIdx = arr[i][j]; 
                        }   
                    }
                    cnt = 1;
                }
            }
            System.out.println("#"+test_case+" "+maxIdx+" "+max);
        }
    }
     
    public static void dfs(int y, int x) {
        for (int d = 0; d < 4; d++) {
            int newY = y + dy[d];
            int newX = x + dx[d];
             
            if (newY < 0 || newY >= N || newX < 0 || newX >= N || visited[newY][newX] || (arr[newY][newX] - arr[y][x]) != 1) {
                continue;
            }
             
            visited[newY][newX] = true;
            cnt++;
            dfs(newY, newX);
            visited[newY][newX] = false;
        }
    }
 
}
