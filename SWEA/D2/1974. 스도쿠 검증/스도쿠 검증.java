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
        	map = new int[9][9];
        	
        	// 배열 저장
        	for (int i=0; i<9; i++) {
            	st = new StringTokenizer(br.readLine());
        		for (int j=0; j<9; j++) { 
        			map[i][j] = Integer.parseInt(st.nextToken());
            	}
        	}
        	
        	int res = 0;        	
        	if (rowCheck() && colCheck() && squCheck()) res = 1;
        	else res = 0;
        	       	      	
        	sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }
    
    static boolean isRight(int[] check) {
    	Arrays.sort(check);
    	for (int i=0; i<9; i++) {
    		if (check[i] != i+1) return false;
    	}
    	return true;
    }
    
    static boolean rowCheck() {
    	for (int i=0; i<9; i++) {
    		int[] check = new int[9];
    		for (int j=0; j<9; j++) {
    			check[j] = map[i][j];
    		}
    		if (!isRight(check)) return false;
    	}
    	return true;
    }
    
    static boolean colCheck() {
    	for (int i=0; i<9; i++) {
    		int[] check = new int[9];
    		for (int j=0; j<9; j++) {
    			check[j] = map[j][i];
    		}
    		if (!isRight(check)) return false;
    	}
    	return true;
    }
    
    static boolean squCheck() {
    	for (int sy=0; sy<9; sy+=3) {
    		for (int sx=0; sx<9; sx+=3) {
    			
	    		int[] check = new int[9];
	    		int idx = 0;
    			for (int i=sy; i<3+sy; i++) {
    	    		for (int j=sx; j<3+sx; j++) {
    	    			check[idx] = map[i][j];
    	    			idx++;
    	    		}
    	    	}
	    		if (!isRight(check)) return false;
    		}
    	}
    	return true;
    }
}