import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Stack<int[]> stack = new Stack<>();
		int[] tower = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {			
			int high = Integer.parseInt(st.nextToken());
			
			if (stack.isEmpty()) { // 만약 스택이 비어있다면
				sb.append(0).append(" "); // 0 출력하고
				stack.push(new int[] {high, i}); // 현재값 push
			} else { // 만약 스택이 비어있지 않다면
				
				while (true) {
					if (stack.isEmpty()) { // 만약 스택이 비어있다면
						sb.append(0).append(" "); // 0 출력하고
						stack.push(new int[] {high, i}); // 현재값 push
						break;
					}
					
					int[] top = stack.peek(); // 스택 탑 peek
					
					if (high < top[0]) { // 만약 현재 높이가 탑 높이보다 작다면
						sb.append(top[1]).append(" "); // 탑의 인덱스를 추가
						stack.push(new int[] {high, i}); // 현재값 push
						break;
					} else { // 만약 현재 높이가 탑 높이보다 높다면
						stack.pop();
					}
				}
			}
		}
		// 출력
		System.out.print(sb);
	}
}