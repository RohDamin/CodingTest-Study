import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();

		int res = 0;
		int tmp = 1;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				tmp *= 2;
				stack.push(c);
			} else if (c == '[') {
				tmp *= 3;
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					res = 0;
					break;
				} else if (str.charAt(i - 1) == '(') {
					res += tmp;
				}
				stack.pop();
				tmp /= 2;
			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					res = 0;
					break;
				} else if (str.charAt(i - 1) == '[') {
					res += tmp;
				}
				tmp /= 3;
				stack.pop();
			}
		}

		if (!stack.isEmpty())
			res = 0;
		System.out.println(res);
	}
}
