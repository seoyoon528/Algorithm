package baekJoon;
import java.util.Scanner;

public class Test10819 {
    static int n;
    static boolean[] visited;
    static int[] arr, newArr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        visited = new boolean[n];
        newArr = new int[n];
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        permutation(0);
        System.out.println(max);
    }

    public static void permutation(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(newArr[i] - newArr[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                continue;
            }
            else {
                newArr[depth] = arr[i];
                visited[i] = true;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
