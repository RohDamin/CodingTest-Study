// BFS
import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][][][] visited;

    // 이동: 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static Marble blue, red;
    static int ox, oy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        // map 저장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                } else if (map[i][j] == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                } else if (map[i][j] == 'O') {
                    ox = i;
                    oy = j;
                }
            }
        }
        System.out.println(bfs());
        br.close();
    }

    static int bfs() {
        Queue<Marble> q = new LinkedList<>();
        q.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.rx][blue.ry] = true;

        while (!q.isEmpty()) {
            Marble marble = q.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            // 이동횟수 10회 초과시 -1 리턴
            if (curCnt > 10) return -1;

            for (int i = 0; i<4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                // 1. 빨간 구슬과 파란 구슬 이동
                // 빨간 구슬 벽 만날 때까지 이동
                while (map[newRx+dx[i]][newRy+dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    // 빨간 구슬이 이동 중 구멍을 만날 경우
                    if (newRx == ox && newRy == oy) {
                        isRedHole = true;
                        break;
                    }
                }

                // 파란 구슬 벽 만날 때까지 이동
                while (map[newBx+dx[i]][newBy+dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    // 파란 구슬이 이동 중 구멍을 만날 경우
                    if (newBx == ox && newBy == oy) {
                        isBlueHole = true;
                        break;
                    }
                }

                // 2. 이동 끝난 후 체크
                // 파란 구슬이 구멍에 빠졌으면 무조건 실패 -> 큐에 남은 다른 좌표 보기 위해 continue
                if (isBlueHole) continue;

                // 빨간 구슬은 구멍에 빠졌고, 파란 구슬은 구멍에 빠지지 않은 경우 성공
                if (isRedHole && !isBlueHole) return curCnt;

                // 둘 다 구멍에 빠지지 않았는데, 이동한 위치가 같은 경우 -> 위치 조정
                if (newRx == newBx && newRy == newBy) {
                    if (i == 0) { // 위쪽으로 기울인 경우
                        // 더 큰 x값을 가진 구슬이 뒤로 감
                        if (curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if (i == 1) { // 아래쪽으로 기울인 경우
                        // 더 작은 x값을 가진 구슬이 뒤로 감
                        if (curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if (i == 2) { // 왼쪽으로 기울인 경우
                        // 더 큰 y값을 가진 구슬이 뒤로 감
                        if (curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    } else { // 오른쪽으로 기울인 경우
                        // 더 작은 y값을 가진 구슬이 뒤로 감
                        if (curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                // 두 구슬이 이동할 위치가 처음 방문하는 곳인 경우에만 이동 -> 큐에 추가
                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    q.add(new Marble(newRx, newRy, newBx, newBy, curCnt+1));
                }

            }
        }
        return -1;
    }

    static class Marble {
        int rx, ry, bx, by, cnt;
        Marble (int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
}
