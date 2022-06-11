package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test4963 {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    // 8방향 탐색
    static int dx[] = {0, 0, -1, 1, -1, -1, 1, 1};
    static int dy[] = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int count = 0;

    // 방문할 노드를 차례로 저장할 Queue (BFS)
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            count = 0;

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            // 지도 입력
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        // DFS
                        dfs(i, j);
                        count++;
                        // BFS
//                        q.offer(new Node(i, j));
//                        bfs();
                    }
                }
            }
            System.out.println(count);
            // q.clear();
        }
    }

    static class Node {     // BFS를 탐색을 위한 Node
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int d = 0; d < 8; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;     // 방문하지도 않았고, 섬이라면
                q.offer(new Node(nx, ny));  // 큐에 넣어주기
            }
        }
        count++;
    }

    public static void dfs(int row, int col) {
        for (int d = 0; d < 8; d++) {
            int nx = row + dx[d];
            int ny = col + dy[d];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}
