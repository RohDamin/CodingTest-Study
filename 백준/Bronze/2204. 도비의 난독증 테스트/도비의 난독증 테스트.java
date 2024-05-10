// 문자열
import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static Long time = (long)0;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> hashMap = new HashMap<>();

		while(true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			String[] words = new String[N]; 
			
			for (int i=0; i<N; i++) {
				String word = br.readLine();
				String lower = word.toLowerCase();
				hashMap.put(lower, word);
				words[i] = lower;
			}
			Arrays.sort(words);
			
			sb.append(hashMap.get(words[0])).append("\n");
		}
		System.out.println(sb);
	}
}
