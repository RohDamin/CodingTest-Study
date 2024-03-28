// 동적 계획법(Dynamic Programming)

import java.io.*;
import java.util.*;

public class Main {
    static int[]arr = new int[100001];
    static int[][]dp;
    static int N;
    static int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];

        dp[1][0] = 1;
        dp[1][1] = 2;

        for (int i = 2; i<=N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1])%MOD;
            dp[i][1] = (dp[i-1][1] + 2*dp[i-1][0])%MOD;
        }

        System.out.println((dp[N][0] + dp[N][1])%MOD);
    }
}
