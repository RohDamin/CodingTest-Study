/**
 * knapsack Problem
 * - 대표적인 DP 알고리즘
 */
import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	static int[] bagW; // 무게
	static int[] bagV; // 가치
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 넣을 수 있는 무게
		
		dp = new int[N+1][K+1];
		bagW = new int[N+1];
		bagV = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			bagW[i] = Integer.parseInt(st.nextToken());
			bagV[i] = Integer.parseInt(st.nextToken());
		}

		// bottom up 방식 풀이
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				
				// i번째 무게를 더 담을 수 없는 경우
				if (bagW[i] > j) dp[i][j] = dp[i-1][j];
				// i번째 무게를 더 담을 수 있는 경우
				else {
					// 이전 가치(현재 물건 안담음)의 값과
					// 현재 물건을 담고(담으면 남은 무게는 j-bagW[i]) 남은 무게의 최대 가치 + 현재 가치(현재 물건을 담았으니까)의 값
					// 2개를 비교해 더 큰 것을 dp 배열에 저장
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bagW[i]]+bagV[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}