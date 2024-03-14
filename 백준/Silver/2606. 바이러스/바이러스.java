import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i<C; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        dfs(1);

        System.out.println(cnt);
    }

    static void dfs (int n) {
        if (visited[n]) return;
        visited[n] = true;
        
        for (int i = 0; i<=N; i++) {
            if (graph[n][i] == 1 && !visited[i]) {
                cnt++;
                dfs(i);
            }
        }
    }
}