package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] water = new int[N];
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 1;
        Arrays.sort(water);
        double tape = water[0] + L - 0.5;

        for (int i = 1; i < N; i++) {
            if (tape < water[i]) {
                cnt++;
                tape = water[i] + L - 0.5;
            }
        }
        System.out.println(cnt);
    }
}
