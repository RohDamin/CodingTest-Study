import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int time = 0; // 걸린 시간
    static int x1, y1, x2, y2;
    static Queue<int[]> waterQ, swanQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 초기화
        init();

        // map에 위치 저장
        for (int i = 0; i<R; i++) {
            String s = br.readLine();
            for (int j = 0; j<C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'L') { // 백조 공간
                    // 물 공간으로 저장
                    map[i][j] = '.';

                    if (x1 == -1 && y1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }

                if (map[i][j] == '.') {// 물 공간
                    waterQ.add(new int[] {i, j});
                }
            }
        }

        visited[x1][y1] = true;
        swanQ.add(new int[] {x1, y1});

        while (true) {
            if (!move()) break;
            melting();
            time++;
        }

        System.out.println(time);

    }

    static boolean isRange(int x, int y) {
        return x>=0 && y>=0 && x<R && y<C;
    }

    static boolean move() {
        // bfs 탐색으로 얼음과 맞닿아 있는 지점을 swanQ에 저장
        // 만약 현재 탐색한 구역이 x2, y2라면 bfs 탐색 종료 -> false 리턴
        Queue<int[]> q = new LinkedList<>();

        while (!swanQ.isEmpty()) {
            int[] now = swanQ.poll();

            // 이번 탐색칸이 백조공간인지 체크 -> 맞으면 bfs 종료 -> false 리턴
            if (now[0] == x2 && now[1] == y2) return false;

            // 백조공간이 아닌 경우 bfs
            for (int d = 0; d<4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                // 다음 탐색칸이 범위 내에 있고 && 방문한 적 없다면
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    // 방문 완료
                    visited[nx][ny] = true;

                    // 물 공간인 경우: 백조 이동 가능 -> swanQ에 추가
                    // 빙판 공간인 경우: 다음에 탐색할 공간 -> q에 추가
                    if (map[nx][ny] == '.') {
                        swanQ.add(new int[] {nx, ny});
                    } else if (map[nx][ny] == 'X') {
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

        // while문 지나서 swanQ는 비어 있음
        // 다음 탐색지역이 저장된 q로 갱신해줌
        swanQ = q;

        return true;
    }

    static void melting() {
        // bfs 탐색으로 얼음과 맞닿아 있는 지점을 녹여줌
        // 방금 녹인 얼음의 위치를 새로운 물 위치를 담은 큐로 갱신해줌
        int size = waterQ.size();

        for (int s = 0; s<size; s++) {
            int[] now = waterQ.poll();

            for (int d = 0; d<4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                // 다음 탐색칸이 범위 내에 있고 && 빙판 공간이라면 녹일 수 있음
                if (isRange(nx, ny) && map[nx][ny] == 'X') {
                    // 물 공간으로 변경
                    map[nx][ny] = '.';

                    // waterQ에 추가
                    waterQ.add(new int[] {nx, ny});
                }
            }
        }
    }
    
    static void init() {
        waterQ = new LinkedList<>();
        swanQ = new LinkedList<>();
        x1 = -1;
        y1 = -1;
        visited = new boolean[R][C];
        map = new char[R][C];
    }
}