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

			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N+1][N+1];
			
			for (int i=1; i<=N; i++) {
				String s = br.readLine();
				for(int j=1; j<=N; j++) {
					farm[i][j] = s.charAt(j-1)-'0';
				}
			}
			int res = upperSum(farm, N) + lowerSum(farm, N);
			sb.append(res).append("\n");
		}	
		System.out.print(sb);
	}
	
	static int upperSum(int[][] farm, int n) {
		int sum = 0;
		int mid = n/2+1;
		int s, e;

		for (int i=1; i<=(n/2)+1; i++) {
			s = mid-i+1;
			e = mid+i-1;
			for (int j=s; j<=e; j++) {
				sum += farm[i][j];
			}
		}
		return sum;
	}
	
	static int lowerSum(int[][] farm, int n) {
		int sum = 0;
		int mid = n/2+1;
		int s, e;
		int cnt = 0;

		for (int i=n; i>(n/2)+1; i--) {
			s = mid-cnt;
			e = mid+cnt;
			cnt++;
			for (int j=s; j<=e; j++) {
				sum += farm[i][j];
			}
		}
		return sum;
	}
}