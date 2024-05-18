import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int maxLen = Math.min(N, M);
		
		map = new int[N+1][M+1];
		
		for (int i=1; i<=N; i++) {
			String s = br.readLine();
			for (int j=1; j<=M; j++) {
				map[i][j] = s.charAt(j-1)-'0';
			}
		}
		
		int res = 0;
		for (int len=maxLen; len>0; len--) {
			if(square(len)) {
				res = len*len;
				break;
			}
		}
		
		System.out.println(res);
	}
	
	static boolean square(int len) {
		for (int i=1; i<=N-len+1; i++) {
			for (int j=1; j<=M-len+1; j++) {
				int a = map[i][j];
				int b = map[i+len-1][j];
				int c = map[i][j+len-1];
				int d = map[i+len-1][j+len-1];
				if (isSame(a, b, c, d)) return true;
			}
		}
		return false;
	}
	
	static boolean isSame(int a, int b, int c, int d) {
		return (a == b && b == c && c == d);
	}
}