import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;

    static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    static int N, M, X, Y, K;

    // 동 서 북 남
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 이동 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int op = Integer.parseInt(st.nextToken());
            move(op); // 함수 호출
        }
    }

    static void move(int op) {
        int nx = X + dx[op - 1];
        int ny = Y + dy[op - 1];
        if (!isRange(nx, ny)) return;
        roll(op, nx, ny);
        X = nx;
        Y = ny;
    }

    static void roll(int op, int x, int y) {
        int tmp = dice[3];
        switch (op) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }

        if (map[y][x] == 0) map[y][x] = dice[6];
        else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }
        System.out.println(dice[3]);
    }

    static boolean isRange(int x, int y) {
        return x>=0 && y>=0 && x<M && y<N;
    }
}


