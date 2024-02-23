// Binary Search
import java.io.*;
import java.util.*;

public class Main {
    public static long[][] arr;
    public static int N;
    public static long H_atk;
    public static long H_maxHP;
    public static long H_curHP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 방의 개수
        H_atk = Integer.parseInt(st.nextToken()); // 용사의 초기 공격력
//        H_maxHP = 1; // 용사의 최대 생명력 - 이진탐색
        H_maxHP = Long.MAX_VALUE-1; // 용사의 최대 생명력 - 이진탐색


        long t, a, h;
        arr = new long[N][3];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // t
            arr[i][1] = Integer.parseInt(st.nextToken()); // a
            arr[i][2] = Integer.parseInt(st.nextToken()); // h

//            if (arr[i][0] == 1) H_maxHP += arr[i][1]*arr[i][2];
        }

        H_curHP = H_maxHP; // 현재 용사의 생명력

        long max = H_maxHP; // 가장 큰 수
        long min = 1;
        long mid = 0;

        while (min<=max) {
            mid = (min+max)/2;

            boolean possible = cal_maxHP(mid);
//            System.out.printf("possible: %b   min: %d   mid: %d   max: %d\n", possible, min, mid, max);

            if (!possible) { // false일 경우
                min = mid+1; // maxHP 증가시켜야 함
            } else { // ture일 경우
                max = mid-1; // maxHP 감소시켜야 함
            }
        }
       System.out.println(min);
    }

    public static boolean cal_maxHP (long maxHP ) {

        H_curHP = maxHP; // 현재 체력 초기화
        H_maxHP = maxHP; // 최대 체력 초기화
        long atk = H_atk; // 공격력이 변경될 수 있으므로 새 변수 정의

        for(int i = 0; i<N; i++) {
            if (arr[i][0] == 1) {
                if (arr[i][2] % atk == 0) { // 몬스터의 체력 / 용사 공격력 나머지가 0이면
                    H_curHP -= arr[i][1]*((arr[i][2] / atk) - 1);
                } else { // 나머지가 0이 아닌 경우
                    H_curHP -= arr[i][1]*((arr[i][2] / atk));
                }
                if (H_curHP <= 0) { // 몬스터가 이긴 경우 false;
                    return false;
                }

            } else {
                atk += arr[i][1];
                H_curHP += arr[i][2];
                if (H_curHP > H_maxHP) H_curHP = H_maxHP;
            }
        }
        return true;
    }
}