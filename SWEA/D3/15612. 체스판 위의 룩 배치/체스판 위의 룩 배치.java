import java.util.*;
import java.io.*;

public class Solution {
	static char[][] chess;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		chess = new char[8][8];
		
		StringTokenizer st;
		for (int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			for (int i=0; i<8; i++) {
				String s = br.readLine();
				for (int j=0; j<8; j++) {
					chess[i][j] = s.charAt(j);
				}
			}
			
			boolean res = isPossible();
			if (res) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}	
		System.out.print(sb);
	}
	
	static boolean isPossible() {
		// ture 초기화
		boolean[][] check = new boolean[8][8];
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				check[i][j] = true;
			}
		}
		
		int cnt = 0;
		
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				
				if (chess[i][j] == 'O') {
					if (!check[i][j]) return false;
					if (cnt>8) return false;
					
					cnt ++;
					
					for (int c=0; c<8; c++) {
						check[i][c] = false;
						check[c][j] = false;
					}
				}
			}
		}
		
		if (cnt != 8) return false;
		return true;
	}
}
