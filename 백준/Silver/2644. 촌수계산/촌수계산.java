/*
# BFS
# 너비 우선 탐색(Breadth-First Search)
- 큐 이용해 구현 가능
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N, A, B, M;
    static int [][] map;
    static int [] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        d = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        bfs(A, B);

        if (d[B] == 0) System.out.print(-1);
        else System.out.print(d[B]);
    }

    static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            if (v == end) break;

            for (int i = 0; i<=N; i++) {
                if (map[v][i] == 1 && d[i] == 0) {
                    d[i] = d[v] + 1;
                    q.add(i);
                }
            }
        }
    }
}