import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt=0;
		//int op = 0;
		while (true) {
			cnt++;
			int change = 0;
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			if (s.charAt(0) == '-') break;
			
			for (int i=0; i<s.length(); i++) {
				if (s.charAt(i) == '{')	stack.add(s.charAt(i));
				else { // } 인 경우
					if (stack.isEmpty()) {
						change++;
						stack.add('{');
					}
					else stack.pop();
				}
			}
			
			sb.append(cnt).append(". ").append(change + stack.size()/2).append("\n");
		}
		System.out.println(sb);
	}
}