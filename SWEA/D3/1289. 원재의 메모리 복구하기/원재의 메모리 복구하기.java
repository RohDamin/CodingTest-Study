import java.util.*;
import java.io.*;

public class Solution {
	static char[][] chess;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			
			String s = br.readLine();
			int prev = 0;
			int change = 0;
			for (int i=0; i<s.length(); i++) {
				int v = s.charAt(i)-'0';
				
				// 만약 prev와 현재 값이 다르다면 -> 값 변경된 것
				if (prev != v) {
					change++; // 카운트 추가
					prev = v; // prev 값을 현재 값으로 변경
				}
			}
			sb.append(change).append("\n");
		}	
		System.out.print(sb);
	}
}