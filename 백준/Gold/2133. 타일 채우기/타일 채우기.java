// 동적 계획법(Dynamic Programming)

import java.io.*;
import java.util.*;

public class Main {
    static int[]dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[31];

        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        dp[4] = 11;

        if (N<5) {
            System.out.println(dp[N]);
        } else {
            if (N%2 == 1) dp[N] = 0;
            else {
                for (int i = 6; i<=N; i+=2) {
                    dp[i] = dp[i-2] * 4 - dp[i-4];
                }
            }
            System.out.println(dp[N]);
        }
    }
}
