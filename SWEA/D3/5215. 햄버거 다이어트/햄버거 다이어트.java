/**
 * knapsack Problem
 * - 대표적인 DP 알고리즘
 */
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int t=0; t<T; t++) {
    		st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int L = Integer.parseInt(st.nextToken());
    		
    		int[] taste = new int[N+1];
    		int[] cal = new int[N+1];
    		int[][] dp = new int[N+1][L+1];
    		
    		for (int n=1; n<=N; n++) {
        		st = new StringTokenizer(br.readLine());
    			taste[n] = Integer.parseInt(st.nextToken());
    			cal[n] = Integer.parseInt(st.nextToken());
    		}
    		for (int i=1; i<=N; i++) {
    			for (int j=0; j<=L; j++) {
    				if (j<cal[i]) dp[i][j] = dp[i-1][j];
    				else {
    					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cal[i]]+taste[i]);
    				}
    			}
    		}
    		sb.append("#").append(t+1).append(" ").append(dp[N][L]).append("\n");
    	}
    	
        System.out.println(sb);
    }
}