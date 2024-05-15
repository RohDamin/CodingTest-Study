import java.io.*;
import java.util.*;
public class Solution {
	static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	map = new int[N][N];
        	
        	// 배열 저장
        	if(N==1) {
        		map[0][0] = 1;
        	} else {
            	saveNum(N);

        	}
        	
        	sb.append("#").append(t).append("\n");;
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) { 
        			sb.append(map[i][j]).append(" ");
            	}
        		sb.append("\n");
        	}
        }
        System.out.print(sb);
    }
    
    static void saveNum(int N) {
    	String[] dir = {"right", "down", "left", "up"};
    	int dirIdx = 0;
    	int cnt = 0;
    	int movelen = N-1;
    	int py = 0;
    	int px = 0;
    	int cur = 0;
    	
    	while (cnt < N*N) {
    		if (dir[dirIdx].equals("right")) {
    			int ml = movelen;
    			while (ml != 0) {
    				cnt++;
    				map[py][px] = cnt;
    				px++;
    				ml--;
    			}
    			dirIdx++;
    		} else if (dir[dirIdx].equals("down")) {
    			int ml = movelen;
    			while (ml != 0) {
    				cnt++;
    				map[py][px] = cnt;
    				py++;
    				ml--;
    			}
    			dirIdx++;
    		} else if (dir[dirIdx].equals("left")) {
    			int ml = movelen;
    			while (ml != 0) {
    				cnt++;
    				map[py][px] = cnt;
    				px--;
    				ml--;
    			}
    			dirIdx++;
    		} else if (dir[dirIdx].equals("up")) {
    			int ml = movelen;
    			while (ml != 0) {
    				cnt++;
    				map[py][px] = cnt;
    				py--;
    				ml--;
    			}
    			dirIdx = 0;
        		movelen -= 2;
        		cur++;
        		px = cur;
        		py = cur;
    		}
    		
    		// N이 홀수인 경우 
    		if (movelen==0) {
    			map[N/2][N/2] = N*N;
    			return;
    		}
    	}
    }
}