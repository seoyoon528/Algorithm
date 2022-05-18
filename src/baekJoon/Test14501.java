package baekJoon;

import java.util.Scanner;

public class Test14501 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] arr = new int[n+2];

        for(int i = 1; i <= n; i++) {
            T[i] = in.nextInt();
            P[i] = in.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            if (i + T[i] <= n+1) {
                arr[i + T[i]] = Math.max(arr[i + T[i]], arr[i] + P[i]);
            }
            arr[i+1] = Math.max(arr[i+1], arr[i]);
        }
        System.out.println(arr[n+1]);
    }
}
