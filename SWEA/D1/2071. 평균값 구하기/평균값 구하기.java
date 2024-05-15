import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	float sum = 0;
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<10; i++) { 
        		sum += Float.parseFloat(st.nextToken());
        	}
        	
        	int avg = Math.round(sum/10);
        	        	      	
        	sb.append("#").append(t).append(" ").append(avg).append("\n");
        }
        System.out.print(sb);
    }
}