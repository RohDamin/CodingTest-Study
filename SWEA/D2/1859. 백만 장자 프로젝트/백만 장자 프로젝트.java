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
        	long[] sell = new long[N+1];
        	int minIdx = 0;
        	int maxIdx = 0;
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=1; i<=N; i++) {
        		sell[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	long buy = 0;
        	long res = 0;
        	int maxidx = N;
        	for (int i=N-1; i>0; i--) {
        		if (sell[i] < sell[maxidx]) res += sell[maxidx] - sell[i];
        		else maxidx = i;
        	}
        	        	      	
        	sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }
}