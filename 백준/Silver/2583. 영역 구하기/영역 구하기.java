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
    static int M, N, K;
    static int [][] paper;
    static boolean [][] visit;
    static int cnt = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ArrayList <Integer> list = new ArrayList<>();

        paper = new int[N][M];
        visit = new boolean[N][M];

        for (int k = 0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int bottonLeftX = Integer.parseInt(st.nextToken());
            int bottonLeftY = Integer.parseInt(st.nextToken());
            int topRightX = Integer.parseInt(st.nextToken());
            int topRightY = Integer.parseInt(st.nextToken());

            for (int i = bottonLeftX; i<topRightX; i++) {
                for (int j = bottonLeftY; j<topRightY; j++) {
                    paper[i][j] = 1;
                }
            }
        }

        for (int n = 0; n<N; n++) {
            for (int m = 0; m<M; m++) {
                if (paper[n][m] == 0 && !visit[n][m]) {
                    dfs(n, m);
                    list.add(cnt);
                    cnt = 0; // cnt 초기화
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i<list.size(); i++) System.out.print(list.get(i) + " ");
    }
    static void dfs(int x, int y) {
        cnt ++;
        visit[x][y] = true;

        for (int i = 0; i<4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy>= 0 && cx < N && cy < M) {
                if (paper[cx][cy] == 0 && !visit[cx][cy]) {
                    dfs(cx, cy);
                }

            }
        }
    }
}