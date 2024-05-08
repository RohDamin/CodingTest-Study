import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static char[][] arr;
	static boolean[][] visited;
	static String res = "NO";

	// 북 북동 동 남동 남 남서 서 북서
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			visited = new boolean[N][N];
			
			// 배열에 입력
			for (int i=0; i<N; i++) {
				String s = br.readLine();
				for (int j=0; j<N; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			// String res = "NO";
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					
					if (arr[i][j] == 'o' && !visited[i][j]) {
						for (int dir=0; dir<8; dir++) {
							dfs(i, j, dir, 1);
							visited = new boolean[N][N];
							if (res.equals("YES")) break;
						}
						
					}
					
				}
			}
			sb.append("#").append(t+1).append(" ").append(res).append("\n");
			res = "NO";
			
		}		
		
		System.out.print(sb);
	}
	
	static void dfs(int y, int x, int d, int cnt) {
		if (cnt>=5) {
			res = "YES";
			return;
		}
		
		visited[y][x] = true;
		
		int ny = y + dy[d];
		int nx = x + dx[d];
	
		if (isRange(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 'o') {
			dfs(ny, nx, d, ++cnt);
		}
	}
	
	static boolean isRange(int y, int x) {
		return y>=0 && x>=0 && y<N && x<N;
	}
}