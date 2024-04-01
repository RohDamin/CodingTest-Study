// DFS + 백트래킹
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 10;
        map = new int[N][N];

        StringTokenizer st;
        // map 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        if (ans == Integer.MAX_VALUE) ans = -1;

        System.out.println(ans);
        br.close();
    }

    static void dfs(int x, int y, int cnt) {
        // 마지막 점에 도착한 경우 ans 비교하고 리턴
        if (x>=9 && y>9) {
            ans = Math.min(ans, cnt);
            return;
        }

        // 최솟값을 구해야 하는데,
        // cnt가 ans보다 커지면 더 탐색할 필요가 없으므로 리턴
        if (cnt >= ans) return;

        // 한 줄을 다 탐색했으면 아래 줄로 이동
        if (y>9) {
            dfs(x+1, 0, cnt);
            return;
        }

        if (map[x][y] == 1) {
            for (int i =5; i>= 1; i--) { // 큰 사이즈부터 체크
                if (paper[i] > 0 && checkPaper(x, y, i)) { // 해당 종이 사이즈가 남아있고, 색종이를 붙일 수 있는 경우
                    attachPaper(x, y, i, 0); // 색종이를 붙임
                    paper[i]--;

                    dfs(x, y+1, cnt+1); // 다음 칸으로 이동해 dfs

                    attachPaper(x, y, i, 1); // 색종이를 다시 뗌
                    paper[i]++;

                }
            }
        } else { // 다음 칸으로 이동
            dfs(x, y+1, cnt);
        }
    }

    // 색종이를 붙이는 함수
    private static void attachPaper(int x, int y, int size, int state) {
        for (int i = x; i<x+size; i++) {
            for (int j = y; j<y+size; j++) {
                map[i][j] = state;
            }
        }
    }

    // 색종이를 붙일 수 있는지 확인하는 함수
    private static boolean checkPaper(int x, int y, int size) {
        for (int i = x; i<x+size; i++) {
            for (int j = y; j<y+size; j++) {
                // 범위를 벗어나거나, 0이 나오는 경우 false 리턴
                if (!isRange(i, j)) return false;
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
}
