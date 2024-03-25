import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp, map;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M+1][N+1];
        dp = new int[M+1][N+1];

        for (int i = 1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i<=M; i++) {
            for (int j = 1; j<=N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));
    }

    public static int dfs (int x, int y) {
        if (x == M && y == N) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for (int i = 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny)) {
                if (map[x][y] > map[nx][ny]) dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }

    public static boolean isRange(int x, int y) {
        if (x>0 && y>0 && x<=M && y<=N) return true;
        else return false;
    }
}