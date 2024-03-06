import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] board;
    static boolean[] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visit = new boolean[26];

        for (int i=0; i<R; i++) {
            String s = br.readLine();
            for (int j=0; j<C; j++) {
                board[i][j] = s.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, int c) {
        visit[board[x][y]] = true;
        max = Math.max(max, c);

        for (int i = 0; i<4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
                if (!visit[board[cx][cy]]) {
                    dfs(cx, cy, c+1);
                    visit[board[cx][cy]] = false;
                }
            }
        }
    }
}