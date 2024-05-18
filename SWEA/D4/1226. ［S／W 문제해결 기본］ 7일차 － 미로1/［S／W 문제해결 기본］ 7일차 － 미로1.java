import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int sy, sx;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		for (int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			sy = 0;
			sx = 0;
			
			map = new int[16][16];
			visited = new boolean[16][16];
			
			// 배열 저장
			for (int i=0; i<16; i++) {
				String s = br.readLine();
				for (int j=0; j<16; j++) {
					map[i][j] = s.charAt(j)-'0';
					
					if (map[i][j] == 2) {
						sy = i;
						sx = j;
					} 
				}
			}
			
			// bfs
			int res = 0;
			if (bfs()) res = 1;
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static boolean bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sy, sx});
		visited[sy][sx] = true;
		
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int py = p[0];
			int px = p[1];
			
			for (int i=0; i<4; i++) {
				int ny = py + dy[i];
				int nx = px + dx[i];
								
				if (!visited[ny][nx] && map[ny][nx] != 1) {
					if (map[ny][nx] == 3) return true;
					q.add(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
		
		return false;
	}
}