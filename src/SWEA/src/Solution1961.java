import java.util.Scanner;

public class Solution1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arrN = new int[N][N];
            String[][] newArrN = new String[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arrN[i][j] = sc.nextInt();
                }
            }

            // 90도 돌기
            for (int i = 0; i < N; i++) {
                String tmp = "";
                for (int j = N-1; j >= 0; j--) {
                    tmp += arrN[j][i];
                }
                newArrN[i][0] = tmp;
            }

            // 180도 돌기
            int step180 = 0;
            for (int i = N-1; i >= 0; i--) {
                String tmp = "";
                for (int j = N-1; j >= 0; j--) {
                    tmp += arrN[i][j];
                }
                newArrN[step180][1] = tmp;
                step180++;
            }

            // 270도 돌기
            int step270 = 0;
            for (int i = N-1; i >= 0; i--) {
                String tmp = "";
                for (int j = 0; j < N; j++) {
                    tmp += arrN[j][i];
                }
                newArrN[step270][2] = tmp;
                step270++;
            }

            // 출력
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(newArrN[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
