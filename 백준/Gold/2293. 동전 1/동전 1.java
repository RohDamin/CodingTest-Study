// 동적 계획법(Dynamic Programming)

import java.io.*;
import java.util.*;

public class Main {
    static int[]dp;
    static int[]coin;
    static int N, K;
    static long cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K+1];
        coin = new int[N+1];
        cnt = 0;

        for (int i = 1; i<=N; i++) coin[i] = Integer.parseInt(br.readLine());

        dp[0] = 1;
        for (int i = 1; i<=N; i++) {
            for (int j = coin[i]; j<=K; j++) {
                dp[j] = dp[j-coin[i]] + dp[j];

            }
        }
        System.out.println(dp[K]);
    }
}