// 완전탐색
import java.io.*;
import java.util.*;
public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        int cnt = 0;
        
        // 저장
        for (int i=0; i<N; i++) {
        	String str = br.readLine();
        	for (int j=0; j<N; j++) {
            	board[i][j] = str.charAt(j);
            } 
        }
        
        
        int py=0, px=0, ny=0, nx=0;
        int max = 0;
        
    	// 행 교환
        for (int i=0; i<N; i++) {
        	py = ny = i;
        	for (int j=0; j<N-1; j++) {
        		px = j;
        		nx = j+1;
        		
        		char pb =  board[py][px];
        		char nb =  board[ny][nx];
        		
        		// 색이 다른지 체크
        		if (pb != nb) {
        			// swap
            		board[py][px] = nb;
            		board[ny][nx] = pb;
        		};
        		
        		max = Math.max(max, count(board, N));

        		// 원래대로 swap
        		if (pb != nb) {
        			board[py][px] = pb;
            		board[ny][nx] = nb;
        		};
        	}
        }
        
    	// 열 교환
        for (int i=0; i<N; i++) {
        	px = nx = i;
        	for (int j=0; j<N-1; j++) {
        		py = j;
        		ny = j+1;
        		
        		char pb =  board[py][px];
        		char nb =  board[ny][nx];
        		
        		// 색이 다른지 체크
        		if (pb != nb) {
        			// swap
            		board[py][px] = nb;
            		board[ny][nx] = pb;
        		};
        		
        		max = Math.max(max, count(board, N));

        		// 원래대로 swap
        		if (pb != nb) {
        			board[py][px] = pb;
            		board[ny][nx] = nb;
        		};
        	}
        }
       
        
		System.out.println(max);

    }
    
    static int count(char[][] nums, int N) {
    	// 행 체크
    	int rowMax = 0;
    	for (int i=0; i<N; i++) {
        	int cnt = 1;
    		for (int j=0; j<N-1; j++) {
        		char now = nums[i][j];
        		
        		if (nums[i][j+1] == now) {
        			cnt++;
        		} else {
        			cnt = 1;
        			rowMax = Math.max(cnt, rowMax);
        			now = nums[i][j+1];
        		}
        		rowMax = Math.max(cnt, rowMax);
        	}
    	}
    	
    	// 열 체크
    	int colMax = 0;
    	for (int i=0; i<N; i++) {
        	int cnt =1;
    		for (int j=0; j<N-1; j++) {
        		char now = nums[j][i];

        		if (nums[j+1][i] == now) {
        			cnt++;
        		} else {
        			cnt = 1;
        			colMax = Math.max(cnt, colMax);
        			now = nums[j+1][i];
        		}
        		colMax = Math.max(cnt, colMax);
        	}
    	}
    	
    	return Math.max(rowMax, colMax);
    }
}