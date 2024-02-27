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
    static int N, M, K;
    static int [][] trash;
    static boolean [][] visit;
    static int max = 0;
    static int cnt = 1;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 통로 세로 길이
        M = Integer.parseInt(st.nextToken()); // 통로 가로 길이
        K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수

        trash = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for (int k = 0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            trash[r][c] = 1; // 음식물이 떨어진 좌표 1로 변경
        }

        for (int n = 0; n<=N; n++) {
            for (int m = 0; m<=M; m++) {
                if (trash[n][m] == 1 && !visit[n][m]) {
                    dfs(n, m);
                    max = Math.max(max, cnt);
                    cnt = 1; // cnt 초기화
                }
            }
        }

        System.out.println(max);

    }
    static void dfs(int x, int y) {
        visit[x][y] = true; // 현재 입력받은 값 방문 완료

        for (int i = 0; i<4; i++) {
            int cx = x+dx[i];
            int cy = y+dy[i];

            if (cx>=0 && cx<=N && cy>=0 && cy<=M) {
                if (trash[cx][cy] == 1 && !visit[cx][cy]) {
                    dfs(cx, cy);
                    cnt++;
                }
            }
        }
    }
}