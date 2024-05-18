import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static int[] code = new int[8];
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());;
		for (int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 1. 암호를 배열에 저장
			map = new int[N][M];
			for (int i=0; i<N; i++) {
				String s = br.readLine();
				for (int j=0; j<M; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			
			// 2. 암호 코드 저장
			// 1) 암호의 위치 찾기
			boolean stopflag = false;
			int ey = 0, ex = 0;
			for (int i=N-1; i>=0; i--) {
				for (int j=M-1; j>=0; j--) {
					
					if (map[i][j] == 1) {
						stopflag = true;
						ey = i;
						ex = j;
						break;
					}
				}
				if (stopflag) break;
			}
			
			// 2) 암호 문자열 저장
			String codeStr = "";
			for (int i=ex-55; i<=ex; i++) {
				codeStr += map[ey][i];
			}
			
			// 3) 암호 문자열을 숫자로 변환해 배열에 저장
			for (int i=0; i<8; i++) {
				String numStr = "";
				for (int j=0; j<7; j++) {
					numStr += codeStr.charAt(i*7+j);
				}				
				code[i] = changeNum(numStr);
			}
			
			// 3. 올바른 암호문인지 확인
			int res = 0;
			int even = 0; // 짝수
			int odd = 0; // 홀수
			
			for (int i=0; i<8; i++) {
				if (i%2 != 0) {
					even += code[i];
				} else odd += code[i];
				res += code[i];
			}
						
			if ((odd*3 + even)%10 != 0) { // 맞는 암호코드가 아닌 경우 결과는 0
				res = 0;
			} 
			
			// 4. 결과 출력
			sb.append("#").append(t).append(" ").append(res).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static int changeNum(String str) {
		int n = 0;
		
		if (str.equals("")) n = 0;
		else if(str.equals("0011001")) n = 1;
		else if(str.equals("0010011")) n = 2;
		else if(str.equals("0111101")) n = 3;
		else if(str.equals("0100011")) n = 4;
		else if(str.equals("0110001")) n = 5;
		else if(str.equals("0101111")) n = 6;
		else if(str.equals("0111011")) n = 7;
		else if(str.equals("0110111")) n = 8;
		else if(str.equals("0001011")) n = 9;

		return n;
	}
}