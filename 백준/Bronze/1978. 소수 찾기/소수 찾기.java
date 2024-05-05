import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
			if (prime(arr[i])) cnt++;
		}
		System.out.println(cnt);
	}
	
	static boolean prime(int n) {
		if (n == 1) return false;
		if (n == 2 || n == 3) return true;
		
		int k = 2;
		while (k<n) {
			if (n%k == 0) return false;
			k++;
		}
		return true;
	}	
}