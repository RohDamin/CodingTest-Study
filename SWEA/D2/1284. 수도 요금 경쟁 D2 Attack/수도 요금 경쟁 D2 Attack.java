import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int A = W*P;
			int B = 0;
			if (W<=R) B = Q;
			else B = Q + (W-R)*S;
									
			sb.append("#").append(t).append(" ").append(Math.min(A, B)).append("\n");
			
		}
		System.out.println(sb);
	}
}