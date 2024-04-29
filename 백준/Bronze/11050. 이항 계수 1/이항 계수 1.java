import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		
		int res = factorial(N) / (factorial(N-M) * factorial(M));
		System.out.println(res);
	}
	
	static int factorial(int n) {
		if (n==1 || n==0) return 1;
		return n*factorial(n-1);
	}
}