import java.io.*;
import java.util.*;
public class Solution {
	static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        System.out.print(nums[N/2]);
    }
}