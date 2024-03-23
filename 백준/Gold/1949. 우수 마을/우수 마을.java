/*
 # 동적 계획법(Dynamic Programming)
 */
import java.io.*;
import java.util.*;

public class Main {
    static int[] town;
    static int[][] memo;
    static boolean[] visited;
    static int N;
    static List<ArrayList<Integer>> tree;
    static List<Integer> setNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        town = new int[N+1];
        memo = new int[N+1][2];
        visited = new boolean[N+1];
        tree = new ArrayList<>();

        for (int i = 0; i<=N; i++){
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) {
            town[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);
        int max = -1;
        for (int i = 1; i<=N; i++) {
            for (int j = 0; j<2; j++) {
                if (max < memo[i][j]) max = memo[i][j];
            }
        }
        System.out.println(max);
    }

    static void dfs(int idx) {
        memo[idx][0] = 0;
        memo[idx][1] = town[idx];

        int size = tree.get(idx).size();
        if (size == 0) return;

        visited[idx] = true;
        for (int cur : tree.get(idx)) {
            if (!visited[cur]) {
                dfs(cur);

                // 부모가 우수 마을 X -> 자식은 우수 마을 O/X
                // 부모가 우수 마을 O-> 자식은 우수 마을 X
                if (memo[cur][0] > memo[cur][1]) {
                    memo[idx][0] += memo[cur][0];
                } else {
                    memo[idx][0] += memo[cur][1];
                }
                memo[idx][1] += memo[cur][0];
            }
        }
    }
}