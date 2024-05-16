import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	String str = br.readLine();
        	
        	int res = 1;
        	for (int i=0; i<str.length()/2; i++) {
    			if (str.charAt(i) != str.charAt(str.length()-i-1)) {
    				res = 0;
    				break;
    			}
    		}       	        	        	      	
        	sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }
}