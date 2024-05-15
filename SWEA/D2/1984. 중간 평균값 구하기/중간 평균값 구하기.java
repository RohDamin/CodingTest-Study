import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	
        	float max = Integer.MIN_VALUE;
        	float min = Integer.MAX_VALUE;
        	float sum = 0;
        	
        	// 전체합, 최댓값, 최솟값 구하기
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<10; i++) {
        		float v = Integer.parseInt(st.nextToken());
            	sum += v;
            	max = Math.max(v, max);
            	min = Math.min(v, min);
        	}
        	
        	// 최댓값, 최솟값 제외 평균 구하기
        	int avg = Math.round((sum-max-min)/8);
        	        	        	      	
        	sb.append("#").append(t).append(" ").append(avg).append("\n");
        }
        System.out.print(sb);
    }
}