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
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int remove, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int root = -1;

        graph = new ArrayList<>();
        visited = new boolean[N+1];
        for (int i = 0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == -1) {
                root = i; // 루트 노드 저장
            } else {
                graph.get(v).add(i);
                graph.get(i).add(v);
            }
        }

        remove = Integer.parseInt(br.readLine());
        if (root == remove) System.out.println(0);
        else {
            findLeaf(root);
            System.out.println(cnt);
        }
    }

    public static void findLeaf (int v) {
        visited[v] = true;
        int nodes = 0;
        for (int cur : graph.get(v)) {
            if (cur != remove && !visited[cur]) { // 현재 방문하는 노드가 지울 노드가 아니고 && 방문하지 않았을 때
                nodes ++;
                findLeaf(cur);
            }
        }
        if (nodes == 0) cnt++; // 차일드 노드가 하나도 없으면 리프 노드
    }

}
