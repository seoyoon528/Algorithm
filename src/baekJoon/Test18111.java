package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test18111 {
    static int n, m, b;
    static int[][] ground;

    public static void solution(int high, int low) {
        int ansSec = Integer.MAX_VALUE, ansHigh = 0;

        for(int x = low; x <= high; x++) {
            int sec = 0;
            int tmpB = b;

            for (int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if (ground[i][j] > x) {
                        sec += (ground[i][j] - x) * 2;
                        tmpB += (ground[i][j] - x);
                    }
                    else if (ground[i][j] < x) {
                        sec += (x - ground[i][j]);
                        tmpB -= (x - ground[i][j]);
                    }
                }
            }

            if (tmpB >= 0 && sec <= ansSec) {
                ansSec = sec;
                ansHigh = x;
            }
        }
        System.out.print(ansSec + " " + ansHigh);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        ground = new int[n][m];

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                high = Math.max(high, ground[i][j]);
                low = Math.min(low, ground[i][j]);
            }
        }
        solution(high, low);
    }
}
