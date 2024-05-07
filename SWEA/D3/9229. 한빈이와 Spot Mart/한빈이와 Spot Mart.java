import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
						
			int max = -1;
			
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					if (arr[i]+arr[j]<=M) max = Math.max(max, arr[i]+arr[j]);
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}
}