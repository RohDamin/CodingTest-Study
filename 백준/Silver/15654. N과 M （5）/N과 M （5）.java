import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] nums;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		nums = new int[N];
		used = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		dfs(0, 0);
	}
	
	static void dfs(int idx, int cnt) {
		if (cnt == M) {
			// M 길이 되면 출력
			for (int j=0; j<M; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
			return;
		}
		
		if (idx>N+1) return;

		for (int i=0; i<N; i++) {
			if (!used[i]) {
				arr[cnt] = nums[i];
				used[i] = true;
				dfs(i+1, cnt+1);
				used[i] = false;
			}
		}
	}
}