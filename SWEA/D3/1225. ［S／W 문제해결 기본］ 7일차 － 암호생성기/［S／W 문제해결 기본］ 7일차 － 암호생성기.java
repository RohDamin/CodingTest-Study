//Queue
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		Queue<Integer> q = new LinkedList<Integer>();
		
		StringTokenizer st;
		for (int t=0; t<T; t++) {
			int tNum = Integer.parseInt(br.readLine());
			sb.append("#").append(tNum).append(" ");
			
			// 큐에 암호 저장
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=8; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
			}
			
			boolean isEnd = false;
			while(true) {
				
				for (int i=1; i<=5; i++) {
					int value = q.poll();
					
					int nextValue = value-i;
					
					if (nextValue<=0) { // 숫자가 감소할 때 0보다 작아지는 경우
						nextValue=0; // 값은 0이 되고
						q.add(nextValue); // 0을 큐에 추가
						isEnd = true;
						break; // 루프 종료
					} else q.add(nextValue);
				}
				if (isEnd) break;
				
			}
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}	
		System.out.print(sb);
	}
}
