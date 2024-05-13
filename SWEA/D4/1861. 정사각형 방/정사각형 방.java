import java.io.*;
import java.util.*;
public class Solution {
	static int N;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int max=0, num=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	N = Integer.parseInt(br.readLine());
        	map = new int[N][N];
        	max = 0;
        	num = 0;
        	
        	for (int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j=0; j<N; j++) {	
            		map[i][j] = Integer.parseInt(st.nextToken());
            	}
        	}
        	
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) {
        			moveroom(i, j, 1);
        		}
        	}
        	        	
        	sb.append("#").append(t).append(" ").append(num).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
    
    static int moveroom(int y, int x, int cnt) {
    	for (int i=0; i<4; i++) {
    		int ny = y + dy[i];
    		int nx = x + dx[i];
    		
    		if (!isRange(ny, nx)) continue;
    		if (map[y][x]+1 != map[ny][nx]) continue;
    		
    		// (y, x) 좌표에서 시작해서 몇 개의 방 이동했는지 저장
    		cnt = moveroom(ny, nx, cnt+1);
    		
    		// (y, x) 좌표의 이동 회숫가 최댓값인지 확인, 방 번호 조정 
    		if (cnt>max) {
        		max = cnt;
        		num = map[y][x];
        	} else if (cnt == max) {
        		if (num>map[y][x]) num = map[y][x];
        	}
    		
    		break;
    	}
    
    	return cnt;	
    }
    
    static boolean isRange(int y, int x) {
    	return y>=0 && x>=0 && y<N && x<N;
    }
}