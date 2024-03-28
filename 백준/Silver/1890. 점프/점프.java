// 동적 계획법(Dynamic Programming)

import java.io.*;
import java.util.*;

public class Main {
    static int[][]arr;
    static long[][]dp;
    static int N;
    static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        dp = new long[N+1][N+1];
        dp[1][1] = 1;

        int v = 0;
        StringTokenizer st;
        for (int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                v = arr[i][j];
                if (v == 0) break;

                x1 = i;
                y1 = j + v;
                x2 = i + v;
                y2 = j;

                if (x1 <= N && y1 <= N) dp[x1][y1] += dp[i][j];
                if (x2 <= N && y2 <= N) dp[x2][y2] += dp[i][j];

            }
        }
        System.out.println(dp[N][N]);
    }
}