import java.util.*;
import java.io.*;

public class Solution {
	static char[][] map;
	static int len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		for (int t=1; t<=T; t++) {
			
			// 회문의 길이 저장
			len = Integer.parseInt(br.readLine());
			
			// 글자판 저장
			map = new char[8][8];
			for (int i=0; i<8; i++) {
				String s = br.readLine();
				for (int j=0; j<8; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			// 가로, 세로 회문 개수 카운트
			int rc = rowCount();
			int cc = colCount();
									
			sb.append("#").append(t).append(" ").append(rc + cc).append("\n");
			
		}
		System.out.println(sb);
	}
	
	// 가로 회문 개수를 카운트하는 함수
	static int rowCount() {
		int count = 0;
		for (int i=0; i<8; i++) {
			for (int j=0; j<=8-len; j++) {
				if (checkStr(makeRowStr(i, j))) count++;
			}
		}
		return count;
	}
	
	// 세로 회문 개수를 카운트하는 함수
		static int colCount() {
			int count = 0;
			for (int i=0; i<8; i++) {
				for (int j=0; j<=8-len; j++) {
					if (checkStr(makeColStr(j, i))) count++;
				}
			}
			return count;
		}
	
	// 특정 좌표에서 시작하는 가로 문자열을 만들어주는 함수
	static String makeRowStr(int y, int x) {
		String str = "";
		for (int i=x; i<x+len; i++) {
			str += map[y][i];
		}
		return str;
	}
	
	// 특정 좌표에서 시작하는 세로 문자열을 만들어주는 함수
		static String makeColStr(int y, int x) {
			String str = "";
			for (int i=y; i<y+len; i++) {
				str += map[i][x];
			}
			return str;
		}
	
	// 특정 문자열이 회문인지 확인하는 함수
	static boolean checkStr(String str) {
		for (int i=0; i<str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-i-1)) return false;
		}
		return true;
	}
}