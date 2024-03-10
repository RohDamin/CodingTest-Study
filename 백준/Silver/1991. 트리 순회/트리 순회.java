/*
 # 트리(Tree)

 * 트리는 다음과 같은 조건들을 충족한다.
 1) 연결 그래프이다.
 2) 방향을 무시하였을 때, 싸이클이 존재하지 않는다.
 3) 트리의 간선 개수는 반드시 트리의 정점 개수보다 1작다

 * 전위 순회, 중위 순회, 후위 순회, 레벨 순회가 존재한다.
 * 재귀적인 구조를 가지고 있다.

 */
import java.io.*;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    static int N;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];

        for (int n = 0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[root - 'A'] == null) {
                tree[root-'A'] = new Node(root);
            }

            if (left != '.') {
                tree[left-'A'] = new Node(left);
                tree[root-'A'].left = tree[left-'A'];
            }

            if (right != '.') {
                tree[right-'A'] = new Node(right);
                tree[root-'A'].right = tree[right-'A'];
            }
        }

        preoder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();
    }

    public static void preoder(Node node) { // 전위 순회
        if (node == null) return;
        System.out.print(node.value);
        preoder(node.left);
        preoder(node.right);
    }

    public static void inorder(Node node) { // 중위 순회
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node) { // 후위 순회
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}