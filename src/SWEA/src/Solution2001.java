import java.util.Scanner;

public class Solution2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int max = 0;
            int sum;

            int[][] arrN = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arrN[i][j] = sc.nextInt();
                }
            }
            // arrN 배열을 순차적으로 돌며
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    sum = 0;
                    // 파리채 면적의 합 구하기
                    for (int k = 0; k < M; k++) {
                        for (int q = 0; q < M; q++) {
                            sum += arrN[i+k][j+q];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}
