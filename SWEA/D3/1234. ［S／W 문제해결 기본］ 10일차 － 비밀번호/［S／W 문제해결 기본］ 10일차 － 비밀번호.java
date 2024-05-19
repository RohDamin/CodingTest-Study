import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String code = st.nextToken();
			
			Stack<Integer> stack = new Stack<Integer>(); 
			for (int i=0; i<N; i++) {
				int v = code.charAt(i)-'0';
				if (stack.isEmpty()) stack.add(v);
				else {
					int top = stack.peek();
					if (top == v) {
						stack.pop();
					}
					else {
						stack.add(v);
					}
				}
			}
			
			String res = "";
			while (!stack.isEmpty()) {
				res = stack.pop() + res;
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");

		}
		System.out.println(sb);
	}
}