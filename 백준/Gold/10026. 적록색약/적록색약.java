/*
# DFS
# 깊이 우선 탐색(Depth-First Search)
- 그래프: 정점(vertex/node)와 간선(edge)의 집합
- 무방향 그래프 / 방향 그래프로 나누어짐
- 인접하다(adjacent): node A에서 간선 하나를 거쳐 node B로 이동할 수 있을 때 A와 B가 인접함
  방향 그래프에서는 한쪽만 성립
- 싸이클(cycle): 간선을 따라 시작한 정점으로 돌아오는 경로
- 가중치 그래프 / 멀티 그래프 등 존재
- 스택 / 재귀함수 이용해 구현 가능
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char [][] color;
    static boolean [][] visit;
    static int cnt1, cnt2 = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        color = new char[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j<N; j++) {
                color[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i<N; i++) { // 적록색약이 아닌 경우
            for (int j = 0; j<N; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    cnt1++;
                }
            }
        }

        visit = new boolean[N][N]; // visit 배열 false로 초기화
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (color[i][j] == 'G') color[i][j] = 'R'; // G를 R로 변경
            }
        }
        for (int i = 0; i<N; i++) { // 적록색약인 경우
            for (int j = 0; j<N; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    cnt2++;
                }
            }
        }
        System.out.print(cnt1 + " " + cnt2);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        char temp_color = color[x][y];

        for (int i = 0; i<4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy>= 0 && cx < N && cy < N) {
                if (!visit[cx][cy] && color[cx][cy] == temp_color ) {
                    dfs(cx, cy);
                }

            }
        }
    }
}