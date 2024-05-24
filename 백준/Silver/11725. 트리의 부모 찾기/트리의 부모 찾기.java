import java.util.*;
import java.io.*;

class Main {
	static List<ArrayList<Integer>> tree;
	static boolean[] visited;
	static int[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        node = new int[N+1];
        visited = new boolean[N+1];
        
        tree= new ArrayList<>();
        for (int i=1; i<=N+1; i++) {
        	tree.add(new ArrayList<>());
        }
        
        for (int i=0; i<N-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int node1 = Integer.parseInt(st.nextToken());
        	int node2 = Integer.parseInt(st.nextToken());
        	tree.get(node1).add(node2);
        	tree.get(node2).add(node1);
        }
        
        dfs(1);
        
        for (int i=2; i<=N; i++) {
        	System.out.println(node[i]);
        }
    }
    
    static void dfs(int idx) {
    	visited[idx] = true;
    	for (int i:tree.get(idx)) {
    		if (!visited[i]) {
    			node[i] = idx;
    			dfs(i);
    		}
    	}
    }
}