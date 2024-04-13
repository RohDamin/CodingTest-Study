import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[N+1];
        int cnt = 0;

        makeGraph();

        for (int n = 1; n<=N; n++) {
            if (!visited[n]) {
                BFS(n);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void makeGraph() throws IOException {
        for (int n = 0; n<=N; n++) {
            graph.add(new ArrayList<>());
        }

        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }

    static void BFS (int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while (!q.isEmpty()) {
            int pos = q.poll();
            int size = graph.get(pos).size();

            for (int s = 0; s<size; s++) {
                int next = graph.get(pos).get(s);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}