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

public class Main {
    static class Node {
        int value;
        int parent;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.parent = -1;
            this.left = null;
            this.right = null;
        }
    }

    static Node[] tree;
    static int[] levelMin;
    static int[] levelMax;
    static int order = 0;
    static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new Node[N+1];
        levelMin = new int[N+1];
        levelMax = new int[N+1];
        
        for (int i = 0; i<=N; i++) {
            tree[i] = new Node(i);
            levelMin[i] = N; // levelMin을 N으로 초기화
        }

        for (int i = 1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l != -1) { // 왼쪽 노드가 존재하는 경우
                tree[v].left = tree[l]; // 현재 노드의 left에 왼쪽 노드 연결
                tree[l].parent = v; // 왼쪽 노드의 parent에 현재 노드 번호 저장
            }
            if (r != -1) { // 오른쪽 노드가 존재하는 경우
                tree[v].right = tree[r];
                tree[r].parent = v;
            }
        }

        // parent가 -1이면(변경되지 않았으면) 루트 노드
        for (int i = 1; i<=N; i++) {
            if (tree[i].parent == -1) root = i;
        }

        dfs(tree[root], 0);

        int max = 0;
        int level = 1;

        for (int i = 0; i<=N; i++) {
            int res = levelMax[i] - levelMin[i] + 1;
            if (res > max) {
                max = res;
                level = i+1;
            }
        }
        System.out.println(level + " " + max);
    }

    public static void dfs (Node node, int level) {
        // 중위탐색을 수행하면 탐색 순서가 열 번호와 일치함
        // left -> root -> right 순서 탐색

        // 1. 왼쪽 노드 방문
        // 만약 왼쪽 노드가 null이 아니면 왼쪽 노드 방문
        if (node.left != null) dfs(node.left, level+1);

        // 2. 루트 노드 방문
        order ++; // 몇번째로 방문했는지 기록하는 변수 order의 값 ++
        if (levelMin[level] > order) levelMin[level] = order; // 각 레벨에서 가장 작은 방문 번호 저장
        if (levelMax[level] < order) levelMax[level] = order; // 각 레벨에서 가장 큰 방문 번호 저장

        // 3. 오른쪽 노드 방문
        // 만약 오른쪽 노드가 null이 아니면 왼쪽 노드 방문
        if (node.right != null) dfs(node.right, level+1);

    }
}