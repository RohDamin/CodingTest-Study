// Greedy
import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static Long time = (long)0;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long X = Integer.parseInt(st.nextToken()); // 집 위치		
		long Y = Integer.parseInt(st.nextToken());		
		long W = Integer.parseInt(st.nextToken()); // 가로, 세로 
		long S = Integer.parseInt(st.nextToken()); // 대각선
		
		/**
		 * 경우의 수
		 * 1. W*2 < S: X+Y만큼 가로세로W 이동
		 * 2. 2W > S > W: Math.min(X, Y)만큼 대각선S 이동, Math.abs(X-Y)만큼 가로세로W 이동
		 * 3. S < W && X+Y가 짝수인 경우: Math.max(X, Y)만큼 대각선S 이동
		 * 4. S < W && X+Y가 홀수인 경우: Math.max(X, Y)-1만큼 대각선S 이동, 1번 W이동
		 */
		
		if (X == 0 && Y == 0);
		else if (W*2 <= S) time = (X+Y)*W; 
		else if (S<2*W && S>=W) time =  Math.min(X, Y)*S + Math.abs(X-Y)*W;
		else if (S<W && (X+Y)%2 == 0) time =  Math.max(X, Y)*S;
		else time =  (Math.max(X, Y)-1)*S + W;
		System.out.println(time);
	}
}