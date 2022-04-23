import java.util.Scanner;

/* Two Pointers,Sliding Window-04
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 */


public class ContinuousSubsequence {
    public static void solution(int n, int m, int[] arr){
        int ans = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                ans++;
            }
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    ans++;
                }
            }
        }

//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; i < n; i++) {
//                sum += arr[j];
//                if (sum == m) {
//                    ans++;
//                    break;
//                }
//                else if (sum > m) {
//                    break;
//                }
//            }
//        }
        System.out.print(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(n, m, arr);
    }
}
