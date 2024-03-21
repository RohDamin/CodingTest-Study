/*
 # 동적 계획법(Dynamic Programming)
 */
import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static char[] str1, str2;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();
        int len1 = s1.length();
        int len2 = s2.length();
        str1 = new char[len1];
        str2 = new char[len2];
        dp = new int[len1+1][len2+1];

        List<Integer> arrayList = new ArrayList<>();

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

        ToString(str1, len1, len2);
        System.out.println(dp[len1][len2]);
        System.out.println(sb);

        br.close();
    }

    static void ToString (char[] str, int i, int j) {
        Stack<Character> st = new Stack<>();
        while (i>0 && j>0) {
            if (dp[i][j] == dp[i-1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j-1]) {
                j--;
            } else {
                st.push(str[i-1]);
                i--;
                j--;
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
    }
}