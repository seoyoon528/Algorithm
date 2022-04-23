import java.util.Scanner;

/* Two Pointers,Sliding Window-05
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 */

public class SumOfContinuousSubsequence {
    public static void solution(int n) {
        int ans = 0, sum = 0, lt = 1;
        for (int i = 1; i < n; i++) {
            sum += i;
            if (sum == n) {
                ans++;
            }
            while (sum >= n) {
                sum = sum - lt;
                if (sum == n) {
                    ans++;
                }
                lt++;
            }
        }
        System.out.print(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }
}
