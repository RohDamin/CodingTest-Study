/*
 # 동적 계획법(Dynamic Programming)
 */
import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static char[] str1, str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int len1 = s1.length();
        int len2 = s2.length();
        str1 = new char[len1];
        str2 = new char[len2];
        dp = new int[len1+1][len2+1];

        for (int i = 0; i<len1; i++) {
            str1[i] = s1.charAt(i);
        }
        for (int i = 0; i<len2; i++) {
            str2[i] = s2.charAt(i);
        }

        for (int i = 1; i<=len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[len1][len2]);
        br.close();
    }
}
