package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test17390 {
    public static void solution(int n, int q, int[] arrA, int[][] arrB) {
        int[] sumArr = new int[n];
        Arrays.sort(arrA);
        sumArr[0] = arrA[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i-1] + arrA[i];
        }

        for (int i = 0; i < q; i++) {
            if (arrB[i][0] == 1 || arrB[i][1] == 1) {
                System.out.println(sumArr[arrB[i][1]-1]);
            }
            else {
                System.out.println(sumArr[arrB[i][1]-1] - sumArr[(arrB[i][0]-1)-1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arrB = new int[q][2];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            arrB[i][0] = Integer.parseInt(st.nextToken());
            arrB[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(n, q, arrA, arrB);
    }
}
