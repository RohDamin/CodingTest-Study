import java.util.*;
import java.io.*;

class Main {
	static int N, K;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 시작
        K = Integer.parseInt(st.nextToken()); // 끝
        
        visited = new boolean[100001];
                
        move();
        System.out.println(min);
       
    }
    
    static int move() {    	
    	Queue<int[]> q = new LinkedList<int[]>();
    	q.add(new int[] {0, N}); // 시간, 위치
    	
    	while (!q.isEmpty()) {
    		int[] now = q.poll();
    		visited[now[1]] = true;
    		
    		if (now[1] == K) {
    			min = Math.min(min, now[0]);
    		}
    		
    		if (now[1]*2 <= 100000 && !visited[now[1]*2]) q.offer(new int[] {now[0], now[1]*2}); 
    		if (now[1]-1 >= 0 && !visited[now[1]-1]) q.offer(new int[] {now[0]+1, now[1]-1});  
    		if (now[1]+1 <= 100000 && !visited[now[1]+1]) q.offer(new int[] {now[0]+1, now[1]+1});  

    	}
    	return min;
    }
}