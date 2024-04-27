import java.util.*;
import java.io.*;

public class Solution {
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int maxlen = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			//visited = new boolean[N+1];
			for (int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph.get(x).add(y); // 서로 연결
				graph.get(y).add(x);
			}
			
			for (int i=1; i<=N; i++) {
				visited = new boolean[N+1]; //방문 배열 초기화
				dfs(i, 1);
			}
			
			sb.append(maxlen).append("\n");
			maxlen = 0;
		}	
		System.out.print(sb);
	}
	
	static void dfs(int node, int len) {
		visited[node] = true;
		
		int size = graph.get(node).size();
		for (int s=0; s<size; s++) {
			int nextNode = graph.get(node).get(s);
			if (visited[nextNode]) continue; // 방문한 적 있다면 패스
			else {
				dfs(nextNode, len+1);
				visited[nextNode] = false;
			}
		}
		maxlen = Math.max(maxlen, len);
	}
}
