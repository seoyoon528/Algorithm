package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test2606 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        graph = new ArrayList[com + 1];
        visited = new boolean[com + 1];

        for (int i = 1; i <= com; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향 인접 리스트를 이용한 그래프 구현
            graph[x].add(y);
            graph[y].add(x);
        }
        DFS(1);
        System.out.println(ans);
    }

    public static void DFS(int n) {
        visited[n] = true;

        for (int i : graph[n]) {
            if (!visited[i]) {
                ans++;
                DFS(i);
            }
        }
    }
}
