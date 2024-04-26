import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			float tmp1 = b-a;
			float tmp2 = c-b;
			
			float res = 0;
			
			if (tmp1 == tmp2);
			else {
				if (tmp1<tmp2) res = (tmp2-tmp1)/2;
				else res = (tmp1-tmp2)/2;
				
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}