import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String S = br.readLine();
		String T = br.readLine();
		int res = 0;
		
		Queue<String> q = new LinkedList<String>();
		q.add(S);
		
		while (!q.isEmpty()) {
			String now = q.poll();
			//System.out.println(now);
			if (now.equals(T)) {
				res = 1;
				break;
			}
			if (now.length()>T.length()) break;
			
			// 불가능한 경우 가지치기
			StringBuffer rev = new StringBuffer(now);
			String nowRev = rev.reverse().toString();
			if(!T.contains(now) && !T.contains(nowRev)) continue;
			
			q.add(solve1(now));
			q.add(solve2(now));
			
		}
		
		System.out.println(res);
	}
	
	static String solve1(String str) {
		return str + 'A';
	}
	
	static String solve2(String str) {
		str = str + 'B';
		String str2 = "";
		
		for (int i=str.length()-1; i>=0; i--) {
			str2 += str.charAt(i);
		}
		return str2;
	}
}