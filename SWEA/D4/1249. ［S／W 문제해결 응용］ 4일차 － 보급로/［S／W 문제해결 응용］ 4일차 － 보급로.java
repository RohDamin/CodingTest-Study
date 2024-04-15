import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] cost;
    static int[][] dp;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int min;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            min = Integer.MAX_VALUE;

            for (int i=0; i<N; i++){
                String s = br.readLine();
                for (int j=0; j<N; j++){
                    map[i][j] = s.charAt(j)-'0';
                }
            }
            BFS(0,0);
            System.out.printf("#%d %d\n", t+1, min);
        }
    }

    static void BFS(int y, int x) {
        PriorityQueue<Pos> q = new PriorityQueue<>();
        q.add(new Pos(y, x, 0));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pos p = q.poll();
            int py = p.y;
            int px = p.x;
            int pt = p.t;

            if (py == N-1 && px == N-1) {
                min = Math.min(min, pt);
            }

            for (int i=0; i<4; i++) {
                int ny = py+dy[i];
                int nx = px+dx[i];

                if (!isRange(ny, nx)) continue;
                if (!visited[ny][nx]) {
                    int nt = pt + map[ny][nx];
                    q.add(new Pos(ny, nx, nt));
                    visited[ny][nx] = true;
                }
            }
        }
    }
    static boolean isRange(int y, int x){
        return y>=0 && x>=0 && y<N && x<N;
    }

    static class Pos implements Comparable<Pos> {
        int x, y, t;
        Pos(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.t < o.t) return -1;
            else if (this.t > o.t) return 1;
            else return 0;
        }
    }
}