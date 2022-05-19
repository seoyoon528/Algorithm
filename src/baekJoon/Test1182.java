package baekJoon;

import java.util.Scanner;

public class Test1182 {
    static int n, s;
    static int[] arr;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        s = in.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        subSum(0, 0, 0);

        if (s == 0) {
            ans--;
        }
        System.out.println(ans);
    }
    public static void subSum(int depth, int idx, int sum) {
        if (depth == n) {
            if (sum == s) {
                ans++;
            }
            return;
        }

        subSum(depth + 1, idx + 1, sum + arr[idx]);     // 해당 인덱스의 원소 값을 sum에 추가하는 경우
        subSum(depth + 1, idx + 1, sum);    // 해당 인덱스의 원소 값을 sum에 추가하지 않는 경우
    }
}
