// 동적 계획법(Dynamic Programming)

import java.io.*;
import java.util.*;

public class Main {
    static int[]dp;
    static int[]arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        arr = new int[N+1];

        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 1);

        int max = 0;

        for (int i = 1; i<=N; i++) {
            for (int j = 0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        System.out.println(N-max);
    }
}
