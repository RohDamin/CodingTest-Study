// Greedy
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		int cnt = 0;
		
		for (int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine()); 
		}
		
		
		while (true) {
			if (K == 0) break;
			
			for (int i=N-1; i>=0; i--) {
				if (K >= coin[i]) {
					cnt += K/coin[i];
					K -= (K/coin[i])*coin[i];
				}
			}
		}
		
		System.out.println(cnt);
	}
}