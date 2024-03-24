/*
 # 동적 계획법(Dynamic Programming)
 */
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static long[][] dp;
    static int N, L;
    static long I;
    static List<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        I = Long.parseLong(st.nextToken());

        dp = new long[N+1][L+1];
        dp[0][0] = 1;

        for (int y = 1; y<=N; y++) {
            dp[y][0] = 1; // 0q
            for (int x = 1; x<=L; x++) {
                // 1 bit를 추가하는 경우 + 0 bit를 추가하는 경우
                dp[y][x] = dp[y-1][x-1] + dp[y-1][x];
            }
        }

        for (int pos = N; pos>0; --pos) {
            final int tempPos = pos;
            long count = IntStream.range(0, L+1).mapToLong(
                    k->dp[tempPos-1][k]).sum();
            int digit;
            if (count<I) {
                digit = 1;
                I -= count;
                L--;
            } else digit = 0;
            sb.append(digit);
        }

        System.out.println(sb);
    }
}