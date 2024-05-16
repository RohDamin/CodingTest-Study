import java.io.*;
import java.util.*;
public class Solution {
	static int[][] map;
	static int[] cols;
	static int colIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = 10;
        
        for (int t=0; t<T; t++) {
        	int N = Integer.parseInt(br.readLine());

            map = new int[100][100];
            int ey=0, ex=0;
            cols = new int[100];
            colIdx = 0;
            
            // 사다리 저장
            for (int i=0; i<100; i++) {
            	st = new StringTokenizer(br.readLine());
            	for (int j=0; j<100; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            		if (i==0 && map[i][j] == 1) {
            			cols[colIdx] = j;
            			colIdx++;

            		}
            		if (map[i][j] == 2) {
            			ey = i;
            			ex = j;
            		}
            	}
            }
            int sx = findStart(ey, ex);
            sb.append("#").append(t+1).append(" ").append(sx).append("\n");
        }
        System.out.println(sb);
    }
    
    static int findStart(int ey, int ex) {
    	int sx = 0;
    	
    	int py = ey;
    	int px = ex;
    	int pIdx = 0;
    	
    	for (int i=0; i<100; i++) {
    		if (cols[i] == ex) {
    			pIdx = i;
    			break;
    		}
    	}
    	while(true) {
    		if (py == 0) {
    			sx = px;
    			break;
    		}
    		
    		// 오른쪽으로 이동하는 경우
    		if (isRange(py, px+1) && map[py][px+1] == 1) {
    			pIdx++;
    			px = cols[pIdx];
    			py--;
    		} else if (isRange(py, px-1) && map[py][px-1] == 1) { // 왼쪽으로 이동하는 경우
    			pIdx--;
    			px = cols[pIdx];
    			py--;
    		} else { // 위쪽으로 이동하는 경우
    			py--;
    		}
    	}
    	return sx;
    }
    
    static boolean isRange(int y, int x) {
    	return y>=0 && x>=0 && y<100 && x<100;
    }
}