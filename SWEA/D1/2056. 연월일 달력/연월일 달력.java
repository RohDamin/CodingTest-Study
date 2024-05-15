import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	sb.append("#").append(t).append(" ");
        	String date = br.readLine();
        	String year = date.substring(0, 4);
        	int month = Integer.parseInt(date.substring(4, 6));
        	String monthStr = date.substring(4, 6);
        	int day = Integer.parseInt(date.substring(6, 8));
        	String dayStr = date.substring(6, 8);
        	
        	if (month<1 || month>12) {
        		sb.append("-1").append("\n");
        		continue;
        	}
        	
        	if (month == 1 || month == 3 || month == 5 || month == 7 
        			|| month == 8 || month == 10 || month == 12) {
        		if (day>0 && day<32) {
        			sb.append(year).append("/").append(monthStr).append("/").append(dayStr).append("\n");
        		} else {
        			sb.append("-1").append("\n");
            		continue;
        		}
        	} else if (month == 4 || month == 6 || month == 9 || month == 11) {
        		if (day>0 && day<31) {
        			sb.append(year).append("/").append(monthStr).append("/").append(dayStr).append("\n");
        		} else {
        			sb.append("-1").append("\n");
            		continue;
        		}
        	} else if (month == 2) {
        		if (day>0 && day<29) {
        			sb.append(year).append("/").append(monthStr).append("/").append(dayStr).append("\n");
        		} else {
        			sb.append("-1").append("\n");
            		continue;
        		}
        	} else {
        		sb.append("-1").append("\n");
        		continue;
        	}
        }
        System.out.print(sb);
    }
}