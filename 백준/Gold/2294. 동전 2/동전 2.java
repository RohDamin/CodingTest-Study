// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 동전 개수
        int K = Integer.parseInt(st.nextToken()); // 만들어야 하는 금액

        arr = new int[N+1];
        for (int i = 1; i<=N; i++) { // 동전 저장
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int []dp = new int[K+1];

        for (int i = 1; i<=K; i++) { // 배열 초기화
            dp[i] = Integer.MAX_VALUE-1;
        }
        dp[0] = 0;

        for (int i = 1; i<=N; i++) {
            for (int j = arr[i]; j<=K; j++) {
                dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
            }
        }

        if (dp[K] == Integer.MAX_VALUE-1) System.out.println(-1);
        else System.out.println(dp[K]);
    }
}
