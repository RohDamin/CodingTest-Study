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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 0;

        while (true) {
            t++;

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 정점의 개수
            int M = Integer.parseInt(st.nextToken()); // 간선의 개수

            if (N == 0 && M == 0) break;

            graph = new ArrayList<>();
            for (int i = 0; i<N+1; i++) {
                graph.add(new ArrayList<>());
            }

            visited = new boolean[N+1];

            for (int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int cnt = 0;
            for (int i = 1; i<N+1; i++) {
                if (!visited[i]) cnt+= checkTree(i);
            }
            if (cnt > 1) System.out.printf("Case %d: A forest of %d trees.\n", t, cnt);
            else if (cnt == 1) System.out.printf("Case %d: There is one tree.\n", t);
            else if (cnt == 0) System.out.printf("Case %d: No trees.\n", t);
        }
    }

    public static int checkTree (int root) {
        // 트리인지 확인
        // 트리일 경우 node = edge + 1

        Queue<Integer> q = new LinkedList<>();
        int node = 0;
        int edge = 0;
        q.add(root); // 큐에 루트 삽입

        while(!q.isEmpty()) { // 큐가 빌 때까지 반복
            int cnt = q.poll(); // 첫번째 요소 poll

            if (visited[cnt]) continue; // 방문한 적 있으면 pass
            visited[cnt] = true; // 방문한 적 없으면 visited true로 바꾸고
            node++; // 노드 개수 추가

            for (int i = 0; i<graph.get(cnt).size(); i++) { // 해당 노드의 차일드 개수만큼 for문 반복
                int nodeNum = graph.get(cnt).get(i); // 해당 노드의 차일드 노드를 구함
                edge++; // 엣지 개수 추가
                if (!visited[nodeNum]) q.add(nodeNum); // 차일드 노드를 방문한 적 없으면 큐에 추가
            }
        }

        // node = edge + 1 성질을 만족하면 트리 -> 1 리턴
        // 만족하지 않으면 트리 X -> 0 리턴
        return (edge/2)+1 == node ? 1 : 0;
    }
}