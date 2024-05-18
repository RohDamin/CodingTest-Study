import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int sy, sx;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		for (int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			for (int i=0; i<N; i++) {
				char c = str.charAt(i);
				
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					stack.add(c);
				} else if (c == ')') {
					if (stack.peek() == '(') stack.pop();
					else stack.add(c);
				} else if (c == ']') {
					if (stack.peek() == '[') stack.pop();
					else stack.add(c);
				} else if (c == '}') {
					if (stack.peek() == '{') stack.pop();
					else stack.add(c);
				} else if (c == '>') {
					if (stack.peek() == '<') stack.pop();
					else stack.add(c);
				}
			}
			
			int res = 1;
			if (!stack.isEmpty()) res = 0;
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
			
		}
		System.out.println(sb);
	}
}