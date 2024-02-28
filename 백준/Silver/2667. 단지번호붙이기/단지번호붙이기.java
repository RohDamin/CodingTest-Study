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
    static int [][] house;
    static boolean [][] visit;
    static int cnt, num = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        house = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j<N; j++) {
                house[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (house[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j);
                    cnt++;
                    list.add(num);
                    num = 0;
                }
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for (int i = 0; i<list.size(); i++) System.out.println(list.get(i));

    }

    static void dfs(int x, int y) {
        num ++;
        visit[x][y] = true;

        for (int i = 0; i<4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy>= 0 && cx < N && cy < N) {
                if (house[cx][cy] == 1 && !visit[cx][cy]) {
                    dfs(cx, cy);
                }

            }
        }
    }
}