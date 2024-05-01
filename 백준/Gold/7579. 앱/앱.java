/**
* knapsack Problem
* - 대표적인 DP 알고리즘
*/
import java.util.*;
import java.io.*;

public class Main {
	 static int N, M;
	    static int[] m;
	    static int[] c;
	    static int[][] dp;

 public static void main(String[] args) throws IOException {
 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = new StringTokenizer(br.readLine());
     N = Integer.parseInt(st.nextToken());
     M = Integer.parseInt(st.nextToken());
     m = new int[N];
     c = new int[N];
     dp = new int[N][10001];

     StringTokenizer str1 = new StringTokenizer(br.readLine());
     StringTokenizer str2 = new StringTokenizer(br.readLine());

     for (int i = 0; i < N; i++) {
         m[i] = Integer.parseInt(str1.nextToken());
         c[i] = Integer.parseInt(str2.nextToken());
     }
     
     int answer = Integer.MAX_VALUE;
     for (int i = 0; i < N; i++) {
         int cost = c[i];
         int memory = m[i];

         for (int j = 0; j <= 10000; j++) {
             if (i == 0) {
                 if (j >= cost) dp[i][j] = memory;
             } else {
                 if (j >= cost) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + memory);
                 else dp[i][j] = dp[i-1][j];
             }
             if (dp[i][j] >= M) answer = Math.min(answer, j);
         }
     }
     System.out.println(answer);
     }
}