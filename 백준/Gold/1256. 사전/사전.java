/*
 # 동적 계획법(Dynamic Programming)
 */
import java.io.*;
import java.util.*;

public class Main {
    static double[][] dp = new double[101][101];
    static int N, M;
    static double K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // a 개수
        M = Integer.parseInt(st.nextToken()); // z 개수
        K = Double.parseDouble(st.nextToken());

        if (check(N, M) < K) {
            System.out.println("-1");
        } else {
            makeS(N, M, K);
            System.out.println(sb.toString());
        }
    }

    public static double check (int a, int z) {
        if (a == 0 || z == 0) return 1;
        if (dp[a][z] != 0) return dp[a][z];

        return dp[a][z] = Double.min(check(a-1, z) + check(a, z-1), 1000000001);
    }

    public static void makeS (int a, int z, double k) {
        if (a == 0) {
            for (int i = 0; i<z; i++) sb.append("z");
            return;
        }
        if (z == 0) {
            for (int i = 0; i<a; i++) sb.append("a");
            return;
        }

        double check = check(a-1, z);
        if (check < k) {
            sb.append("z");
            makeS(a, z-1, k-check);
        } else {
            sb.append("a");
            makeS(a-1, z, k);
        }
    }
}