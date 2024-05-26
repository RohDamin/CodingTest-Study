// 위상 정렬(Topological Sort)
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] indegree = new int[N+1];
        
        for (int i=0; i<=N; i++) {
        	graph.add(new ArrayList<Integer>());
        }
        
        for (int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
        	graph.get(a).add(b);
        	indegree[b]++;
        }
        
        
        Queue<Integer> q= new LinkedList<Integer>();
        for (int i=1; i<=N; i++) {
        	if (indegree[i] == 0) {
        		q.add(i);
        	}
        }
        
        while (!q.isEmpty()) {
        	int cur = q.poll();
    		sb.append(cur).append(" ");

        	for (int next : graph.get(cur)) {
        		indegree[next]--;
        		if (indegree[next] == 0) q.add(next);
        	}
        }
        
        System.out.println(sb);
    }
}