import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int [][] rain;
    static boolean [][] visit;
    static int maxH, maxNum, cnt = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        rain = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<N; j++) {
                rain[i][j] = Integer.parseInt(st.nextToken());
                if (maxH < rain[i][j]) maxH = rain[i][j]; // 최대 높이 구하기
            }
        }

        for (int h = 1; h<=maxH; h++) { // 0~최대 높이 동안 maxNum 구하기
            visit = new boolean[N][N]; // visit 초기화
            cnt = 0; // cnt 초기화

            for (int i = 0; i<N; i++) {
                for (int j = 0; j<N; j++) {
                    if (rain[i][j] >= h && !visit[i][j]) { // 물에 잠기지 않고 && 방문하지 않은 영역인 경우
                        dfs(i, j, h);
                        cnt++;
                    }
                }
            }
            if (maxNum < cnt) maxNum = cnt;
        }
        System.out.print(maxNum);
    }

    static void dfs(int x, int y, int h) {
        visit[x][y] = true;

        for (int i = 0; i<4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy>= 0 && cx < N && cy < N) {
                if (rain[x][y] >= h && !visit[cx][cy]) {
                    dfs(cx, cy, h);
                }

            }
        }
    }
}