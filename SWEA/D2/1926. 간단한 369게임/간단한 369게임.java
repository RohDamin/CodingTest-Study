import java.io.*;
import java.util.*;
public class Solution {
	static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i=1; i<=N; i++) {
        	String num = String.valueOf(i);
        	if (num.contains("3") || num.contains("6") || num.contains("9")) {
        		for (int n=0; n<num.length(); n++) {
            		if (num.charAt(n) == '3' || num.charAt(n) == '6' || num.charAt(n) == '9') {
            			sb.append('-');
            		}
            	}
        		sb.append(" ");
        	} else {
        		sb.append(num).append(" ");
        	}
        	
        }
        
        System.out.print(sb);
    }
}