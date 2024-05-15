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
        	int[] score = new int[101];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<1000; i++) {
        		int s = Integer.parseInt(st.nextToken());
        		score[s]++;
        	}
        	
        	int maxIdx = 0;
        	int maxValue = 0;
        	for (int i=0; i<100; i++) {
        		if (score[i] >= maxValue) {
        			maxValue = score[i];
        			maxIdx = i;
        		}
        	}
        	        	      	
        	sb.append("#").append(t).append(" ").append(maxIdx).append("\n");
        }
        System.out.print(sb);
    }
}