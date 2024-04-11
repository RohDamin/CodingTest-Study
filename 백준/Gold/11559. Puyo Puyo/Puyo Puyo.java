import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    static int chainCnt = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i<12; i++) {
            String str = br.readLine();
            for (int j = 0; j<6; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        boolean state = false;
        while (true) {
            for (int i = 0; i<12; i++) {
                for (int j = 0; j<6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        if (isBoom(map[i][j], i, j)) state = true;
                    }

                }
            }

            // 하나도 터지지 않았다면 반복문 종료
            if (!state) break;

            // 터진 것이 있다면
            visited = new boolean[12][6]; // 방문 배열 초기화
            move(); // 아래로 이동
            chainCnt++; // 카운트 증가
            state = false; // 종료조건 초기화

        }
        System.out.println(chainCnt);
    }

    static boolean isBoom(char color, int y, int x) {
        // 방문한 적 있으면 탐색완료한 노드 -> 탐색X
        // 방문한 적 없으면 true 변경하고 탐색 시작
        if (visited[y][x]) return false;
        else visited[y][x] = true;

        // bfs
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> removeQ = new LinkedList<>();
        q.add(new int[] {y, x});
        removeQ.add(new int[] {y, x});
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int py = pos[0];
            int px = pos[1];

            for (int i = 0; i<4; i++) {
                int ny = py+dy[i];
                int nx = px+dx[i];

                // 다음 좌표가 범위 안에 있고 && 방문한 적 없고 && 같은 색인 경우
                if (isRange(ny, nx) && !visited[ny][nx] && color == map[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx});
                    removeQ.add(new int[] {ny, nx});
                    cnt++;
                }
            }
        }

        // 탐색을 끝낸 후, cnt가 4 이상이라면 change 함수 호출
        if (cnt>=4) {
            change(removeQ);
            return true;
        }
        return false;
    }

    // 뿌요가 터진 경우, 터진 자리에 '.'을 저장하는 함수
    static void change(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int py = pos[0];
            int px = pos[1];

            map[py][px] = '.';
        }
    }

    // 뿌요를 아래로 이동시키는 함수
    static void move() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    static boolean isRange(int y, int x) {
        return y>=0 && x>=0 && y<12 && x<6;
    }
}