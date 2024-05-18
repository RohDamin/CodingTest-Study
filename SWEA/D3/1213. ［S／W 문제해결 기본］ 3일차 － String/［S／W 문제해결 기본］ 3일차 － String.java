import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		for (int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			String target = br.readLine();
			String str = br.readLine();
			int cnt = 0;
			
			for (int i=0; i<str.length()-target.length()+1; i++) {
				String subStr = str.substring(i, i+target.length());
				if (subStr.equals(target)) { 
					cnt++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}
}