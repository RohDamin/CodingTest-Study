import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] map;
	static int de = 0;
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			// 인덱스=행, 각 인덱스의 값=열
			map = new int[N];
			
			dfs(0);

			sb.append("#").append(t+1).append(" ").append(de).append("\n");
			de = 0;
		}
		
		System.out.print(sb);
	}
	
	public static void dfs(int depth) {
		if (depth == N) {
			de++;
			return;
		}
		
		for (int i=0; i<N; i++) {
			map[depth] = i;
			if (possible(depth)) dfs(depth+1);
		}
	}
	
	public static boolean possible(int col) {
		for (int i=0; i<col; i++) {
			if (map[col] == map[i]) return false; // 행
			else if (Math.abs(col-i) == Math.abs(map[col]-map[i])) return false; // 대각선
		}
		return true;
	}

}
