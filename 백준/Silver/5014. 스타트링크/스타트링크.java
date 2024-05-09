// BFS
import java.util.*;
import java.io.*;

public class Main {
	static int F, S, G, U, D;
	static boolean[] visited;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); // 전체 층수
		S = Integer.parseInt(st.nextToken()); // 현재 층
		G = Integer.parseInt(st.nextToken()); // 목표 층
		U = Integer.parseInt(st.nextToken()); // 위층
		D = Integer.parseInt(st.nextToken()); // 아래층
		
		visited = new boolean[F+1];

		int res = bfs();
		
		if (res>=0) System.out.println(res);
		else System.out.println("use the stairs");
		
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {S, 0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nf = now[0];
			int nc = now[1];
			
			// 목표 층에 도착한 경우
			if (nf == G) return nc;
			
			else {
				
				int uf = nf+U;
				int df = nf-D;
				
				if (uf<=F && !visited[uf]) {
					q.add(new int[] {uf, nc+1});
					visited[uf] = true;
				}
				if (df>=1 && !visited[df]) {
					q.add(new int[] {df, nc+1});
					visited[df] = true;
				}
			}
		}
		return -1;
	}
}