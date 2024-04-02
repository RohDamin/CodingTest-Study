import java.io.*;
import java.util.*;

public class Main {
    static int[][] gear = new int[5][9];
    static boolean[] isMoved = new boolean[5];
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // map 저장
        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();
            for (int j = 1; j <= 8; j++) {
                gear[i][j] = s.charAt(j-1) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()); // 움직일 톱니바퀴 번호

            boolean direction; // 움직일 방향
            if (Integer.parseInt(st.nextToken()) == 1) direction = true; // 시계방향
            else direction = false; // 반시계방향

            isMoved = new boolean[5];
            moveGear(gearNum, direction);
        }

        System.out.println(score());
        br.close();
    }

    // 기어 회전하는 함수
    static void moveGear(int gearNum, boolean direction) {
        isMoved[gearNum] = true;

        // 1번 기어를 돌리는 경우
        if (gearNum == 1) {
            // 1번 기어와 2번 기어가 다른 극이고, 2번 기어를 돌리지 않은 경우
            if (gear[gearNum][3] != gear[gearNum+1][7] && !isMoved[gearNum+1]) {
                moveGear(gearNum+1, !direction);
            }
            // 현재 기어 돌리기
            if(direction) clockwise(gearNum);
            else counterclockwise(gearNum);
        }

        // 2번, 3번 기어를 돌리는 경우
        if (gearNum == 2 || gearNum == 3) {
            // 현재 기어와 뒤 기어가 다른 극이고, 뒤 기어를 돌리지 않은 경우
            if (gear[gearNum][7] != gear[gearNum-1][3] && !isMoved[gearNum-1]) {
                moveGear(gearNum-1, !direction);
            }
            // 현재 기어와 앞 기어가 다른 극이고, 앞 기어를 돌리지 않은 경우
            if (gear[gearNum][3] != gear[gearNum+1][7] && !isMoved[gearNum+1]) {
                moveGear(gearNum+1, !direction);
            }
            // 현재 기어 돌리기
            if(direction) clockwise(gearNum);
            else counterclockwise(gearNum);
        }

        // 4번 기어를 돌리는 경우
        if (gearNum == 4) {
            // 4번 기어와 3번 기어가 다른 극이고, 3번 기어를 돌리지 않은 경우
            if (gear[gearNum][7] != gear[gearNum-1][3] && !isMoved[gearNum-1]) {
                moveGear(gearNum-1, !direction);
            }
            // 현재 기어 돌리기
            if(direction) clockwise(gearNum);
            else counterclockwise(gearNum);
        }
    }

    // 시계 방향 회전
    static void clockwise (int gearNum) {
        int[] newGear = new int[9];
        for (int i = 1; i<=7; i++) {
            newGear[i+1] = gear[gearNum][i];
        }
        newGear[1] = gear[gearNum][8];
        gear[gearNum] = newGear;
    }

    // 반시계방향 회전
    static void counterclockwise (int gearNum) {
        int[] newGear = new int[9];
        for (int i = 1; i<=7; i++) {
            newGear[i] = gear[gearNum][i+1];
        }
        newGear[8] = gear[gearNum][1];
        gear[gearNum] = newGear;
    }

    // 점수를 계산하는 함수
    static int score() {
        int score = 0;
        if (gear[1][1] == 1) score += 1;
        if (gear[2][1] == 1) score += 2;
        if (gear[3][1] == 1) score += 4;
        if (gear[4][1] == 1) score += 8;
        return score;
    }
}