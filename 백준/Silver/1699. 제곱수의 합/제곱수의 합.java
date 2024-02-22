// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr = new int[317];
    public static int[] dp; // 제곱수 합의 최소 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int [N+1];

        for (int i = 1; i<=N; i++) {
            dp[i] = i;
            for (int j = 1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}