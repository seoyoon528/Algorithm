import java.util.Scanner;

public class Solution1959 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] arrN = new int[N];
            int[] arrM = new int[M];

            for(int i = 0; i < N; i++) {
                arrN[i] = sc.nextInt();
            }
            for(int j = 0; j < M; j++) {
                arrM[j] = sc.nextInt();
            }

            if (N < M) {
                System.out.println("#" + test_case + " " + mulSum(N, M, arrN, arrM));

            } else {
                System.out.println("#" + test_case + " " + mulSum(M, N, arrM, arrN));
            }
        }
    }
    public static int mulSum(int small, int big, int[] smallArr, int[] bigArr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= big - small; i++) {
            int step = 0;
            int sum = 0;
            while (step < small) {
                sum += smallArr[step] * bigArr[i + step];
                step++;
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
