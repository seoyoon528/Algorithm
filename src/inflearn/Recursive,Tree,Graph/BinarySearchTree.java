class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class BinarySearchTree {
    Node root;

    public void DFS(Node root) {
        if (root == null) {
            return;
        }
        else {      // 중위순회 (InOrder)
            DFS(root.lt);       // 얘 먼저 재귀적으로 실행되어 스택에 쌓이고
            System.out.print(root.data + " ");      // 해당 노드의 data값 출력
            DFS(root.rt);       // 스택에 쌓였던 lt들이 실행되면서 rt 노드 추가
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
