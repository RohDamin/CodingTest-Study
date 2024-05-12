// DFS
import java.util.*;
import java.io.*;

public class Solution {	
	static int []arr;
	static int cnt = 0;
	static int N, K;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = 0;
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs (int idx, int sum) {
		if (idx == N) {
			if (sum == K) cnt++;
			return;
		}
		// 현재 인덱스를 선택하는 경우
		dfs(idx+1, sum+arr[idx]);
		
		// 현재 인덱스를 선택하지 않는 경우
		dfs(idx+1, sum);
	}
}