package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test1303 {
    static char[][] combatMap;
    static boolean[][] combatVisited;

    static int wCnt = 0;
    static int bCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        combatMap = new char[m][n];
        combatVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            combatMap[i] = br.readLine().toCharArray();
        }

        int wSum = 0;
        int bSum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!combatVisited[i][j]) {
                    if (combatMap[i][j] == 'W'){
                        wCnt = 0;
                        combatVisited[i][j] = true;
                        DFS(m, n, i, j, 'W');
                        wSum += wCnt * wCnt;
                    }
                    else if (combatMap[i][j] == 'B'){
                        bCnt = 0;
                        combatVisited[i][j] = true;
                        DFS(m, n, i, j, 'B');
                        bSum += bCnt * bCnt;
                    }
                }
            }
        }
        System.out.println(wSum + " " + bSum);
    }

    public static void DFS(int m, int n, int col, int row, char ch) {
        // 4방향 탐색
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        if (ch == 'W') {
            wCnt++;
        } else {
            bCnt++;
        }

        for (int d = 0; d < 4; d++) {
            int newX = row + dx[d];
            int newY = col + dy[d];

            if (newX < 0 || newX >= n || newY < 0 || newY >= m || combatMap[newY][newX] != ch || combatVisited[newY][newX]) {
                continue;
            }

            combatVisited[newY][newX] = true;
            DFS(m, n, newY, newX, ch);
        }
    }
}
