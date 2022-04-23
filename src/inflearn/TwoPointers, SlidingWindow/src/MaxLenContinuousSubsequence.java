import java.util.Scanner;

/* Two Pointers,Sliding Window-06
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다.
 * 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 * 1 1 0 0 [1 1 1 1 1 1 1 1] 0 1
 * 이며 길이는 8입니다.
 */

public class MaxLenContinuousSubsequence {
    public static void solution(int n, int k, int[] arr){
        int lt = 0, cnt = 0, max = Integer.MIN_VALUE;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            max = Math.max(max, rt-lt+1);
        }
        System.out.print(max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(n, k, arr);
    }
}
