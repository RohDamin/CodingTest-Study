/*
 # 동적 계획법(Dynamic Programming)
 */
import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp, cost;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        dp = new int[N][3];
        cost = new int[N][3];
        
        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫번째 값 초기화. 나머지 dp값은 전부 0
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(RGB(N-1, 0), Math.min(RGB(N-1, 1), RGB(N-1, 2))));
        br.close();
    }

    static int RGB(int i, int color) {
        // 탐색하지 않은 배열이라면
        if (dp[i][color] == 0) {
            if (color == 0){
                dp[i][0] = Math.min(RGB(i-1, 1), RGB(i-1, 2)) + cost[i][0];
            } else if (color == 1) {
                dp[i][1] = Math.min(RGB(i-1, 0), RGB(i-1, 2)) + cost[i][1];
            } else {
                dp[i][2] = Math.min(RGB(i-1, 0), RGB(i-1, 1)) + cost[i][2];
            }
        }
        return dp[i][color];
    }
}