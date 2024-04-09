import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        int cnt = 0;
        
        for (int i = 0; i<n; i++) {
            if (!visited[i]) {
                bfs(computers, i, n);    
                cnt++;
            }
        }
        return cnt;
    }
    
    static void bfs(int[][] computers, int idx, int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.add(idx);
        
        while (!q.isEmpty()){
            int pos = q.poll();
            for (int i = 0; i<n; i++) {
                if(computers[pos][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        
    }
}
