import java.io.*;
import java.util.*;
public class Solution {
	static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int len = N-M+1;
        	map = new int[N][N];
        	
        	// 배열 저장
        	for (int i=0; i<N; i++) {
            	st = new StringTokenizer(br.readLine());
        		for (int j=0; j<N; j++) { 
        			map[i][j] = Integer.parseInt(st.nextToken());
            	}
        	}
        	
        	// 최댓값 구하기
        	int max = 0;
        	for (int i=0; i<len; i++) { 
        		for (int j=0; j<len; j++) { 
        			max = Math.max(max, count(i, j, M));
            	}
        	}
        	        	        	      	
        	sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
    
    static int count(int y, int x, int len) {
    	int sum = 0;

    	for (int i=y; i<y+len; i++) {
    		for (int j=x; j<x+len; j++) {
        		sum += map[i][j];
        	}
    	}
    	return sum;
    }
}