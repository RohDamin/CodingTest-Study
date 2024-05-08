import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] map;
	static int de = 0;
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		
		dfs(0);
		System.out.print(de);
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
	
	public static boolean possible (int col) {
		for (int i=0; i<col; i++) {
			// 행에 같은 값이 있는지 확인
			if (map[i] == map[col]) return false;
			
			// 대각선에 같은 값이 있는지 체크
			// 행-열 절댓값이 같으면 같은 대각선에 있는 것
			else if (Math.abs(col-i) == Math.abs(map[col]-map[i])) return false;
		}
		return true;
	}
}
