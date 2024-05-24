import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int max = 0;
	static int[][] map; 
	static Integer[][] dp; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new Integer[N][N];
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<i+1; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        for (int i=0; i<N; i++) {
        	dp[N-1][i] = map[N-1][i];
        }
        
        System.out.println(find(0,0));
    }
    
    static int find(int depth, int idx) {
    	if (depth == N-1) return dp[depth][idx];
    	
    	if (dp[depth][idx] == null) {
    		dp[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1))+map[depth][idx];
    	}
    	return dp[depth][idx];
    }
}