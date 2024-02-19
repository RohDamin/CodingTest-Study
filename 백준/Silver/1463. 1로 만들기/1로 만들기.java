// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
    public static char arr[][];
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        System.out.print(solution(N));
    }

    public static int solution(int n) {
        if (dp[n] == null) {
            if (n%6 == 0) {
                dp[n] = Math.min(solution(n-1), Math.min(solution(n/3), solution(n/2))) + 1;
            } else if (n%3 == 0) {
                dp[n] = Math.min(solution(n/3), solution(n-1))+1;
            } else if (n%2 == 0) {
                dp[n] = Math.min(solution(n/2), solution(n-1))+1;
            } else {
                dp[n] = solution(n-1)+1;
            }
        }
        return dp[n];
    }
}
