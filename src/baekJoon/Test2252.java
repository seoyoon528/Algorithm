package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degree = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            degree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.offer(node);

            for (int i : graph[node]) {
                degree[i]--;

                if (degree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
