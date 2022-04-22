import java.util.Scanner;

/* Two Pointers,Sliding Window-03
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 15 [11 20 25] 10 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 여러분이 현수를 도와주세요.
 */

public class MaximumSales {
    public static void solution(int n, int m, int[] arr){
        int sum = 0, ans;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        ans = sum;
        for (int j = m; j < n; j++) {
            sum += (arr[j] - arr[j-m]);
            ans = Math.max(ans, sum);
        }

//        int max = Integer.MIN_VALUE;
//        int[] sw = new int[n-m+1];
//
//        for (int i = 0; i < (n-m+1); i++) {
//            for (int j = i; j < i+m; j++) {
//                sw[i] += arr[j];
//            }
//        }
//        for (int i : sw) {
//            if (i > max) {
//                max = i;
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
