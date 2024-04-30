/**
 * knapsack Problem
 * - 대표적인 DP 알고리즘
 */
import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] L = new int[n+1];
        int[] J = new int[n+1];
        int[][] dp = new int[n+1][100];
        
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            L[i] = Integer.parseInt(str1.nextToken());
            J[i] = Integer.parseInt(str2.nextToken());
        }        
                
        for (int i=1; i<=n; i++) {
        	for (int j=1; j<100; j++) {
        		if (j < L[i]) dp[i][j] = dp[i-1][j];
        		else {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]]+J[i]);
        		}
        	}
        }     
        System.out.print(dp[n][99]);
    }
}