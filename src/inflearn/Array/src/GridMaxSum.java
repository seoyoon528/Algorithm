import java.util.Scanner;

/* Array-09
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 */

public class GridMaxSum {
    public static void solution(int n, int[][] arr) {
        int col = 0, row = 0, ldiag = 0, rdiag = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            col = 0;
            for (int j = 0; j < n; j++) {
                col += arr[j][i];
                max = max(max, col);
            }
        }

        for (int i = 0; i < n; i++) {
            row = 0;
            for (int j = 0; j < n; j++) {
                row += arr[i][j];
                max = max(max, row);
            }
        }

        for (int i = 0; i < n; i++) {
            ldiag += arr[i][i];
            max = max(max, ldiag);
        }

        for (int i = n-1; i >= 0; i--) {
            rdiag += arr[i][i];
            max = max(max, rdiag);
        }

        System.out.print(max);
    }

    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        solution(n, arr);
    }
}
