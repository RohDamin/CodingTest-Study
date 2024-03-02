/*
# BFS
# 너비 우선 탐색(Breadth-First Search)
- 큐 이용해 구현 가능
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        visited[0][0] = true;

        for (int i = 0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.print(map[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {// 방문하지 않았고 갈 수 있는 길이면
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = map[nowX][nowY] + 1; // 현재값 +1
                    }
                }
            }
        }
    }
}