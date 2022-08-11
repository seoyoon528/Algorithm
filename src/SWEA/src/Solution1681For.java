package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 정사각형 방 - for문 버전 */
public class Solution1681For {
	
	static int N;
	static int[][] arr;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            
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
            		
            		int cnt = findRoom(i, j);
            		
            		if (cnt > max) {
						max = cnt;
						maxIdx = arr[i][j];
					}
					else if (cnt == max) {
						if (arr[i][j] < maxIdx) {
							maxIdx = arr[i][j];	
						}	
					}
            	}
            }
            
            System.out.println("#"+test_case+" "+maxIdx+" "+max);        
        }
	}
	
	public static int findRoom(int y, int x) {
		int curCnt = 1;
		
		while (true) {
			int dCnt = 0;
			
			for (int d = 0; d < 4; d++) {
				int newY = y + dy[d];
				int newX = x + dx[d];
				
				if (newY < 0 || newY >= N || newX < 0 || newX >= N || (arr[newY][newX] - arr[y][x]) != 1) {
					dCnt++;
					continue;
				}
				curCnt++;
				y = newY;
				x = newX;
			}
			
			if (dCnt == 4) {
				break;
			}
			
		}
		return curCnt;
	}

}
