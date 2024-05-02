import java.util.*;
import java.io.*;

public class Solution {
 public static void main(String[] args) throws IOException {
 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
 	StringTokenizer st;
        
    int T = 10;
    int N = 100;
    
    
    //int sum = 0;
    int[][] map = new int[N+1][N+1];
    for (int t=0; t<T; t++) {
    	int tc = Integer.parseInt(br.readLine());
    	
    	int rowMax = 0;
        int colMax = 0;
        int diagonal1 = 0;
        int diagonal2 = 0;
        
    	// 배열에 저장
    	for (int i=1; i<=100; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j=1; j<=100; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 행, 열, 대각선 최댓값 구하기
    	for (int i=1; i<=100; i++) {
    		int rowSum = 0;
    		int colSum = 0;

    		for (int j=1; j<=100; j++) {
    			rowSum += map[i][j];
    			colSum += map[j][i]; 
    			if (j==100) {
    				rowMax = Math.max(rowMax, rowSum); // 행 최댓값
    				colMax = Math.max(colMax, colSum); // 열 최댓값
    			}
    			
    			if (i==j) diagonal1 += map[i][j]; // 오른쪽 아래 방향 대각선 합
    			if (i==101-j) diagonal2 += map[i][j]; // 왼쪽 아래 방향 대각선 합
    		}
    	}
    	
    	// 행, 열, 대각선 최댓값 중 제일 큰 값 stringBuffer에 추가
    	int max = Math.max(Math.max(rowMax, colMax), Math.max(diagonal1, diagonal2));
    	
    	sb.append("#").append(tc).append(" ").append(max).append("\n");

    }
    System.out.print(sb);
  }
}