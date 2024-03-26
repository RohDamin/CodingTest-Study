// 동적 계획법(Dynamic Programming)

import java.io.*;
import java.util.*;

public class Main {
    static int[]dp;
    static int[] code = new int[5001];
    static int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 1; i<=s.length(); i++) {
            code[i] = s.charAt(i-1)-'0';
        }

        dp = new int[5001];

        dp[0] = 1;

        for (int i = 1; i<=s.length(); i++) {
            // code 배열에 저장
            code[i] = s.charAt(i-1)-'0';
            if (code[i] >= 1 && code[i]<=9) {
                dp[i] += dp[i-1]; // 앞글자 경우의 수 저장
                dp[i] %= MOD;
            }

            // 글자가 1개인 경우 -> stop
            if (i == 1) continue;

            // 0이 연달아 나오는 경우 -> stop
            if (code[i-2] == 0 && code[i-1] == 0) continue;

            // 앞글자 + 뒷글자가 10~26 범위에 있는 경우
            int v = code[i-1]*10 + code[i];
            if (v >= 10 && v <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[s.length()]);
    }
}