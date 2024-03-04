import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static int[][][] map;
    static boolean[][][] visited;
    static int[] start;
    static int cnt = 0;

    // 동서남북상하 이동
    static int[] dx = {1, -1, 0, 0, 0, 0}; // x축
    static int[] dy = {0, 0, -1, 1, 0, 0}; // y축
    static int[] dz = {0, 0, 0, 0, 1, -1}; // z축

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // 층
            R = Integer.parseInt(st.nextToken()); // 행
            C = Integer.parseInt(st.nextToken()); // 열

            if (L==0 && R==0 && C==0) break; // 0 0 0 이면 반복 종료

            map = new int[L][R][C];
            visited = new boolean[L][R][C];

            start = new int[3];
            cnt = 0;

            for (int l = 0; l<L; l++) {
                for (int r = 0; r<R; r++) {
                    String s = br.readLine();
                    for (int c = 0; c<C; c++) {
                        if (s.charAt(c) == '.') map[l][r][c] = 0; // 통로
                        else if (s.charAt(c) == '#') map[l][r][c] = 1; // 벽
                        else if (s.charAt(c) == 'S') {
                            map[l][r][c] = 2; // 입구
                            start[0] = l;
                            start[1] = r;
                            start[2] = c;
                        }
                        else if (s.charAt(c) == 'E') map[l][r][c] = 3; // 출구
                    }
                }
                br.readLine(); // 층 사이 엔터 제거
            }
            cnt = bfs(start[0], start[1], start[2], 0);
            if (cnt == -1) System.out.println("Trapped!");
            else System.out.printf("Escaped in %d minute(s).\n", cnt);
        }
    }

    static int bfs(int x, int y, int z, int c) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {x, y, z, 1}); // 큐에 시작 노드 저장
        visited[x][y][z] = true;

        while (!q.isEmpty()) { // 큐가 소진될 때까지 반복
            int now[] = q.poll(); // 큐의 첫번째 요소 방문
            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];

            for (int i = 0; i<6; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                int nextZ = nowZ + dz[i];

                if (nextX >= 0 && nextY >= 0 && nextZ >= 0 && nextX < L && nextY < R && nextZ < C) {
                    if (!visited[nextX][nextY][nextZ] && map[nextX][nextY][nextZ] != 1) { // 방문하지 않았고 벽(#)이 아닌 경우

                        if (map[nextX][nextY][nextZ] == 3) { // 출구를 찾은 경우
                            return now[3]; // 최단거리 리턴
                        }

                        // 통로(.) 인 경우
                        q.add(new int[] {nextX, nextY, nextZ, now[3]+1}); // 큐에 방문한 노드를 삽입, 현재 최단거리+1
                        visited[nextX][nextY][nextZ] = true; // 방문 표시
                    }
                }
            }
        }
        return -1; // 루프가 모두 끝난 경우 -1 리턴 > 탈출이 불가한 경우
    }
}