
import java.io.*;
import java.util.*;

public class Main {
    static int K, H, W;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();

    // 원숭이 이동방법 4가지(상하좌우)
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {-1, 1, 0, 0};

    // 말 이동방법 8가지
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // x
        H = Integer.parseInt(st.nextToken()); // y

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) { // y
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) { // x
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println( bfs(0, 0));
    }
    
    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x, 0, 0});
        visited[y][x][0] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            int k = pos[2];
            int cnt = pos[3];

            // 도착한 경우 리턴
            if (py == H - 1 && px == W - 1) {
                return cnt;
            }

            // 원숭이 이동
            for (int i = 0; i < 4; i++) {
                int nx = px + mx[i];
                int ny = py + my[i];

                if (isRange(ny, nx) && !visited[ny][nx][k] && map[ny][nx] != 1) {
                    visited[ny][nx][k] = true;
                    q.add(new int[] {ny, nx, k, cnt+1});
                }
            }

            if (k<K) {
                for (int i = 0; i < 8; i++) { // 말 이동
                    int nx = px + hx[i];
                    int ny = py + hy[i];

                    if (isRange(ny, nx) && !visited[ny][nx][k+1] && map[ny][nx] != 1) {
                        visited[ny][nx][k+1] = true;
                        q.add(new int[] {ny, nx, k+1, cnt+1});
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isRange(int y, int x) {
        return x>=0 && y>=0 && x<W && y<H;
    }
}
