import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class BinaryTreeLevelSearch {
    Node root;

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);      // add = offer
        int L = 0;      // Level (= 노드까지의 간선 거리)

        while (!Q.isEmpty()) {
            int len = Q.size();     // 원소 개수, 초기 Q 사이즈는 1(root)
            System.out.print(L + " : ");      // 레벨 출력
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.add(cur.lt);       // cur가 말단 노드가 아니라면 (= cur가 왼쪽 자식이 있으면)
                if (cur.rt != null) Q.add(cur.rt);
            }
            L++;    // 레벨 증가
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeLevelSearch tree = new BinaryTreeLevelSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
