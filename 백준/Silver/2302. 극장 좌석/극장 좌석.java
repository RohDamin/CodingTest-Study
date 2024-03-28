// 동적 계획법(Dynamic Programming)

import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[41];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i<=N; i++) dp[i] = dp[i-1] + dp[i-2];

        int res = 1;
        int prev = 0;

        for (int i = 0; i<M; i++) {
            int temp = Integer.parseInt(br.readLine()); // vip 좌석 저장
            res *= dp[temp-prev-1]; // vip좌석과 좌석 사이 숫자들의 경우의 수
            prev = temp; // 이전 좌석 저장
        }

        res *= dp[N-prev];

        System.out.println(res);
    }
}