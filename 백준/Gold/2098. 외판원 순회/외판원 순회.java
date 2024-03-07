/*
비트마스킹(Bit Masking)
*/
import java.io.*;
import java.util.*;

public class Main {
    static int N, statusFullBit, INF = 987654321;
    static int[][] town;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        statusFullBit = (1<<N) -1;
        town = new int[N][N];
        dp = new int[N][statusFullBit];

        for (int i = 0; i<N; i++){
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                town[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(TSP(0,1));
    }

    static int TSP(int x, int check) {
        if (check == statusFullBit) {
            if (town[x][0] == 0) return INF;
            else return town[x][0];
        }

        if (dp[x][check] != -1) return dp[x][check];

        dp[x][check] = INF;

        for (int i = 0; i<N; i++) {
            int next = check | (1<<i);
            if (town[x][i] == 0 || (check & (1<<i)) != 0) continue;

            dp[x][check] = Math.min(dp[x][check], TSP(i, next) + town[x][i]);
        }
        return dp[x][check];
    }
}