import java.util.Scanner;

public class Solution1979 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int ans = 0;

            int[][] puzzle = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    puzzle[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                int len = 0;
                for (int j = 0; j < N; j++) {
                    if (puzzle[i][j] == 1) {
                        len++;
                    }
                    if (puzzle[i][j] == 0 || j == N - 1) {
                        if (len == K) {
                            ans++;
                        }
                        len = 0;
                    }
                }

                for (int j = 0; j < N; j++) {
                    if (puzzle[j][i] == 1) {
                        len++;
                    }
                    if (puzzle[j][i] == 0 || j == N - 1) {
                        if (len == K) {
                            ans++;
                        }
                        len = 0;
                    }
                }
            }
            System.out.println("#"+ test_case + " " +ans);
        }
    }
}
