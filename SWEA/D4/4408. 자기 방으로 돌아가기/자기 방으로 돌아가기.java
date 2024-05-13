import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int t=1; t<=T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	int[] corridor = new int[201];
        	int time = 1;
        	int max = 0;
        	
        	for (int n=0; n<N; n++) {
        		st = new StringTokenizer(br.readLine());
        		int now = (Integer.parseInt(st.nextToken())+1)/2;
        		int next = (Integer.parseInt(st.nextToken())+1)/2;
        		
        		int len = Math.abs(now-next);        		
        		int s = Math.min(now, next);
        		// 지나는 복도의 값을 1 증가시킴
        		for (int i=s; i<=s+len; i++) {
        			corridor[i] += 1;
        			max = Math.max(max, corridor[i]); // 복도의 최댓값을 저장
        		}
        	}
        	sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}