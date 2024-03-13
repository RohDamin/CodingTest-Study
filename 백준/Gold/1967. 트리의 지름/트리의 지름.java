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
        int wight;
        public Node (int value, int wight) {
            this.value = value;
            this.wight = wight;
        }
    }

    static int N;
    static List<Node>[] tree;
    static boolean [] visited;
    static int maxSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        visited = new boolean [N+1];

        for (int i = 0; i<=N; i++) {
            tree[i] = new ArrayList<Node>();
        }

        for (int i = 1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()); 
            int child = Integer.parseInt(st.nextToken()); 
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        maxSum = 0;

        for (int i = 1; i<=N; i++) {
            Arrays.fill(visited, false); // 전부 false 초기화
            visited[i] = true; // 현재 방문할 노드만 true
            dfs(i, 0);
        }

        System.out.println(maxSum);
    }

    private static void dfs(int value, int sum) {
        for (Node node : tree[value]) {
            if(!visited[node.value]) {
                visited[node.value] = true;
                dfs(node.value, sum + node.wight);
            }
        }
        maxSum = Math.max(maxSum, sum);
    }
}
