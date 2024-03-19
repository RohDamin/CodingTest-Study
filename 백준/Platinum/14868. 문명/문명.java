/*
 # 유니온 파인드(Union-Find / disjoint-set)

 * union, find 2개의 연산만 지원하는 자료구조
 * disjoint한 집합들을 표현하는 자료구조
 * disjoint한 집합이란 어떤 두 집합 사이에도 교집합의 원소가 하나도 없고,
   모든 집합의 합집합은 전체집합인 집합을 의미함
 * 즉, 항상 여러 개의 트리 형태를 띄고 있음

 * find 연산: 어떤 정점의 루트를 찾아줌
 * union 연산: 두 집합을 하나로 합쳐줌

 */
import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, K;
    static int[][] map;
    static int[] parent;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int time = 0; // 걸린 시간
    static int cnt = 1; // 현재 문명의 수
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[K+1];

        for (int i = 1; i<=K; i++) {
            parent[i] = -1;
        }

        // map에 문명 위치 저장
        map = new int[N][N];
        for (int i = 1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;

            map[x][y] = i;
            q.add(new Node(x, y));

            // 인접한 문명이 있는지 체크
            for (int ii = 0; ii<4; ii++) {
                int nextX = x + dx[ii];
                int nextY = y + dy[ii];

                // 다음 값이 범위 안에 있고, 문명인 경우
                // 같은 문명인 경우 false 리턴됨
                // 다른 문명인 경우 true 리턴, 통합 -> 통합이 가능한 경우 cnt++
                if (isRange(nextX, nextY) && map[nextX][nextY] != 0 && union(map[x][y], map[nextX][nextY])) {
                    cnt++;
                }
            }
        }

        while (cnt != K && bfs(time++)) {}
        System.out.println(time);
    }

    static boolean isRange(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }

    static boolean union (int a, int b) {

        // 같은 트리면 false 리턴
        // 같은 트리가 아닐 경우 a에 b를 통합(a가 루트), true 리턴
        if ((a = find(a)) != (b = find(b))) {
            parent[b] = a;
            return true;
        }
        return false;

    }

    static int find (int x) {
        return parent[x] < 0 ? x : (parent[x] = find(parent[x]));
    }


    static boolean bfs(int time) {
        int size = q.size();

        for (int s = 0; s<size; s++) {
            Node now = q.poll();

            for (int d = 0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if (isRange(nextX, nextY) && map[nextX][nextY]==0) {
                    // 문명 X 지역이라면
                    q.add(new Node(nextX, nextY));
                    map[nextX][nextY] = map[now.x][now.y]; // 현재 문명 번호로 채워줌

                    for (int i = 0; i<4; i++) {
                        int nnextX = nextX + dx[i];
                        int nnextY = nextY + dy[i];

                        if (isRange(nnextX, nnextY) && map[nnextX][nnextY] != 0 && map[nextX][nextY] != map[nnextX][nnextY]) {
                            if (union(map[nnextX][nnextY], map[nextX][nextY]) && ++cnt == K) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}