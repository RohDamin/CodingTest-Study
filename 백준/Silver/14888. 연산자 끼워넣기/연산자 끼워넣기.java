import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int[] nums;
	static int[] ops;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 StringTokenizer st;
		 
		 N = Integer.parseInt(br.readLine());
		 nums = new int[N];
		 ops = new int[4];
		 
		 st = new StringTokenizer(br.readLine());
		 for (int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
		 
		 st = new StringTokenizer(br.readLine());
		 for (int i=0; i<4; i++) ops[i] = Integer.parseInt(st.nextToken());
		 
		 recursion(nums[0], 1);
		 System.out.println(max);
		 System.out.println(min);
		 
	}
	
	static void recursion(int val, int idx) {
		if (idx==N) {
			min = Math.min(min, val);
			max = Math.max(max, val);
			return;
		}
		
		for (int i=0; i<4; i++) {
			if (ops[i] != 0) {
				ops[i]--;
				
				if (i==0) recursion(val + nums[idx], idx+1);
				else if (i==1) recursion(val - nums[idx], idx+1);
				else if (i==2) recursion(val * nums[idx], idx+1);
				else recursion(val / nums[idx], idx+1);

				ops[i]++; // 백트래킹
			} 
		}	
	}
}
