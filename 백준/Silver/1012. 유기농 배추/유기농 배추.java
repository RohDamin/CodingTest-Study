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
    static int [][] cabbage;
    static boolean [][] visit;
    static int cnt;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수
            cabbage = new int[M][N];
            visit = new boolean[M][N];
            cnt = 0;

            for (int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                cabbage[p1][p2] = 1; // 배추가 심어져 있는 땅은 1 표시
            }

            for (int m = 0; m<M; m++) {
                for (int n = 0; n<N; n++) {
                    if (cabbage[m][n] == 1 && !visit[m][n]) { // 배추가 심어져 있고 && 방문한 적 없다면
                        dfs(m, n); // dfs 함수 실행
                        cnt++; // 카운트 추가
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void dfs(int x, int y) {
        visit[x][y] = true; // 현재 입력받은 값 방문 완료

        for (int i = 0; i<4; i++){
            int cx = x+dx[i]; // 위, 아래, 왼쪽, 오른쪽 각각 x,y 좌표 계산
            int cy = y+dy[i];

            if (cx >=0 && cx<M && cy>=0 && cy<N) { // 해당 좌표가 M,N 범위 안인 경우
                if(!visit[cx][cy] && cabbage[cx][cy] == 1) { // 해당 좌표에 방문한 적이 없고 && 배추가 심어져 있는 경우
                    dfs(cx, cy); // 인접한 모든 배추 찾기 위해 재귀 호출
                }
            }
        }
    }
}