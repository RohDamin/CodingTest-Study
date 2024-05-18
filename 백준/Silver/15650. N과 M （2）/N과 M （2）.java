import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dfs("", 1);
		
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			for (int j=0; j<M; j++) {
				sb.append(s.charAt(j)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(String str, int idx) {
		if (str.length() == M) {
			list.add(str);
			return;
		}
		if (idx>N) return;

		
		for (int i=idx; i<=N; i++) {
			dfs(str+i, i+1);
		}
	}
}