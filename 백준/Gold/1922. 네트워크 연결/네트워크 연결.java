/**
 * 최소 스패닝 트리 (Minimum Spanning Tree, MST)
 * & 크루스칼 알고리즘(Kruskal's algorithm)
 * 
 * 1. 스패닝 트리(spanning tree/신장 트리)
 * - 무방향 연결 그래프가 있을 때 그 그래프에서 간선을 부분적으로 뽑아서 만들 수 있는
 * - 그래프의 정점 개수와 같은 정점 개수를 가지는 트리
 * - 트리이기 때문에 여전히 연결 그래프이고, 간선 개수는 V-1개로 줄어듦
 * 
 * 2. 최소 스패닝 트리(Minimum Spanning Tree)
 * - 트리의 간선마다 가중치(cost)가 있을 때, 간선의 가중치 합이 최소인 스패닝 트리
 * - 하나의 그래프에서 스패닝 트리는 여러개일 수 있고, MST도 여러 개일 수 있음
 * - 프림 알고리즘(Prim's algorithm), 솔린 알고리즘(Sollin's algorithm), 크루스칼 알고리즘(Kruskal's algorithm) 등이 있음
 * 
 * 3. 크루스칼 알고리즘(Kruskal's algorithm)
 * - 1) 간선들을 가중치 순으로 오름차순 정렬하고, 정점들을 각 컴포넌트로 초기화함
 * - 2) 간선들을 훑으면서 양쪽 정점을 포함한 컴포넌트가 연결되어 있지 않으면, 간선을 뽑고 연결
 * - 3) 간선 V-1개가 뽑혔을 때, 그 간선들과 정점들이 이루는 그래프가 MST
 * - 한 번만 간선을 훑으면 끝남 -> 즉, 자신이 한 결정을 되돌리지 않음
 * - 가장 가중치가 작은 간선부터 훑는다는 점에서 일종의 그리디 알고리즘
 * - 총시간복잡도는 O(ElogE)
 */

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int start, end, weight;
	
	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return weight-o.weight;
	}
}

public class Main {	
	static int[] parent;
	static ArrayList<Edge> edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(start, end, weight));
		}
		
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		Collections.sort(edgeList);
		
		int ans = 0;
		for (int i = 0; i<edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			if (find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		System.out.println(ans);
	}
	
	public static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) parent[y] = x;
	}
}