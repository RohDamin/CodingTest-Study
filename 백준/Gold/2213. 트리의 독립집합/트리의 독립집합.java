/*
 # 동적 계획법(Dynamic Programming)
 */
import java.io.*;
import java.util.*;

public class Main {
    static int[] cost;
    static int[][] memo;
    static boolean[] visited;
    static int N;
    static List<ArrayList<Integer>> tree;
    static List<Integer> setNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N+1];
        memo = new int[N+1][2];
        visited = new boolean[N+1];
        tree = new ArrayList<>();
        setNode = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);
        visited = new boolean[N+1];

        int max = -1;
        int maxIdx = -1;
        boolean maxBln = false;
        // 출력
        for (int i = 1; i<=N; i++) {
            for (int j = 0; j<2; j++) {
                if (max < memo[i][j]) {
                    max = memo[i][j];
                    maxIdx = i;
                    maxBln = j != 0;
                }
            }
        }
        System.out.println(max);
        trace(maxIdx, maxBln);
        Collections.sort(setNode);
        for (int i = 0; i<setNode.size(); i++) {
            System.out.print(setNode.get(i) + " ");
        }
    }

    static void dfs (int parent) {
        // 해당 정점을 포함하지 않았을 때의 최댓값 memo[i][0]에 저장
        // 해당 정점을 포함했을 때의 최댓값 memo[i][0]에 저장
        memo[parent][0] = 0; // 포함X -> 초기값 0
        memo[parent][1] = cost[parent]; // 포함 O -> 초기값 해당 노드 가중치

        // 부모 트리와 연결된 자식 수
        int size = tree.get(parent).size();
        if (size == 0) return;

        visited[parent] = true;
        for (int cur : tree.get(parent)) {
            // 해당 자식 노드 방문한 적 없다면
            // dfs 호출
            if (!visited[cur]) {
                dfs(cur);

                // 가능한 경우의 수
                // 1) 부모 노드 포함 X - 현재 노드 포함 X
                // 2) 부모 노드 포함 X - 현재 노드 포함 O
                // 3) 부모 노드 포함 O - 현재 노드 포함 X
                if (memo[cur][0] > memo[cur][1]) {
                    // 1번 케이스 -> 부모X & 자식X
                    memo[parent][0] += memo[cur][0];
                } else {
                    // 2번 케이스 -> 부모X & 자식O
                    memo[parent][0] += memo[cur][1];
                }
                // 3번 케이스 -> 부모O & 자식X
                memo[parent][1] += memo[cur][0];
            }
        }
    }

    static void trace(int node, boolean b) {
        // 가중치가 최댓값일 때, 누가 참석했는지 역으로 조회
        // memo[i][0], memo[i][1] 중 더 높은 값을 추적하면 됨
        visited[node] = true;

        // 부모 트리와 연결된 자식 수
        int size = tree.get(node).size();
        if (size == 0) return;

        // 호출된 노드가 true인 경우
        if (b) {
            setNode.add(node);
            for (int i = 0; i < size; i++) {
                int next = tree.get(node).get(i);
                if (!visited[next]) trace(next, false);
            }
        } else { // 호출된 노드가 false인 경우
            for (int cur : tree.get(node)) {
                if (!visited[cur] && memo[cur][0] > memo[cur][1]) {
                    trace(cur, false);
                } else if (!visited[cur] && memo[cur][0] <= memo[cur][1]){
                    trace(cur, true);
                }
            }
        }
    }
}
