import java.util.*;
import java.io.*;

public class Main {
	static Integer[][] dp;
	static int[][] bag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		dp = new Integer[N][K+1];
		bag = new int[N][2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken()); // 물건의 무게
			int V = Integer.parseInt(st.nextToken()); // 가치
			
			bag[i][0] = W;
			bag[i][1] = V;
		}
		System.out.print(knapsack(N-1, K));
	}
	
	// top-down 방식
	static int knapsack(int i, int k) {
		// i가 범위 밖이라면 0 리턴
		if (i<0) return 0;
		
		// 탐색하지 않은 위치라면
		if (dp[i][k] == null) { // Integer 배열 -> null로 초기화됨 -> 탐색안한 상태 null
			
			// 현재 물건을 담지 못하는 경우
			if (bag[i][0] > k) dp[i][k] = knapsack(i-1, k); // 이전 가치를 넣어줌
			
			// 현재 물건을 담을 수 있는 경우
			else {
				// i번째 물건을 선택하면서, i-1번째 물건을 선택하는 경우 중,
				// [현재 가능한 최대 무게 - i번째 물건의 무게]까지의 최대 가치를 더한 값
				dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-bag[i][0])+bag[i][1]);
			}
		}
		return dp[i][k];
	}
}