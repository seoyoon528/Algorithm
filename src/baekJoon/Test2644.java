package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test2644 {
    static ArrayList<Integer>[] levelGraph;
    static boolean[] levelVisited;
    static boolean isFind = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        levelGraph = new ArrayList[n + 1];
        levelVisited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            levelGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            levelGraph[x].add(y);
            levelGraph[y].add(x);
        }

        DFS(a, b, 1);
        if (!isFind) System.out.println(-1);
    }

    public static void DFS (int start, int end, int level) {
        levelVisited[start] = true;

        for (int i : levelGraph[start]) {
            if (!levelVisited[i]) {
                if (i == end) {
                    isFind = true;
                    System.out.println(level);
                    return;
                }
                DFS(i, end, level + 1);
            }
        }
    }
}
