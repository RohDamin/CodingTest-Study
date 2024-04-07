import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] tomato;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // x 6
        N = Integer.parseInt(st.nextToken()); // y 4

        tomato = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) { // y
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++) { // x
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) q.add(new int[] {i, j});
            }
        }

        bfs();

        // 익지 않은 토마토가 있다면 cnt는 -1
        for (int i=0; i<N; i++) { // y
            for (int j = 0; j<M; j++) { // x
                if (tomato[i][j] == 0) cnt = -1;
            }
        }
        System.out.println(cnt);
    }

    public static void bfs() {
        while (true) {


            Queue<int[]> nextQ = new LinkedList<>();
            int size = q.size();

            for (int s = 0; s<size; s++) {
                int[] now = q.poll();
                int ny = now[0];
                int nx = now[1];
                visited[ny][nx] = true;

                for (int i = 0; i<4; i++) {
                    int cx = nx + dx[i];
                    int cy = ny + dy[i];

                    // 범위 안에 있고 && 방문한 적 없고 && 익지 않은 토마토가 있다면
                    if (isRange(cy, cx) && !visited[cy][cx] && tomato[cy][cx] == 0) {
                        nextQ.add(new int[] {cy, cx});
                        tomato[cy][cx] = 1;
                    }
                }

            }
            q = nextQ;
            if (q.isEmpty()) return;
            cnt++;
        }
    }

    public static boolean isRange(int y, int x) {
        return x>=0 && y>=0 && x<M && y<N;
    }
}