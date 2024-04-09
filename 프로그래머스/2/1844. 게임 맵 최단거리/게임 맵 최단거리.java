import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int n, m;
    static int cnt = -1;
    
    public int solution(int[][] maps) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        dfs(maps);
        return cnt;
    }
    
    static void dfs (int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1}); // 처음 y, x, c
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            int c = pos[2];
            
            if (py == n-1 && px == m-1) {
                cnt = c;
                return;
            }
            
            for (int i = 0; i<4; i++) {
                int ny = py + dy[i];
                int nx = px + dx[i];
                
                if (isRange(ny, nx) && !visited[ny][nx] && maps[ny][nx] != 0) {
                    q.add(new int[] {ny, nx, c+1});
                    visited[ny][nx] = true;
                }
            }
        }    
    }
    
    static boolean isRange(int y, int x) {
        return y>=0 && x>=0 && y<n && x<m;
    }
}