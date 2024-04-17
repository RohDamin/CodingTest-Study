// 브루트포스
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(arr, N, M);
        System.out.println(res);
    }

    static int solve(int[]arr, int N, int M) {
        int result = 0;
        for (int i=0; i<N-2; i++) {
            for (int j=i+1; j<N-1; j++) {
                for (int k=j+1; k<N; k++) {
                    int sum = arr[i]+arr[j]+arr[k];
                    if (M == sum) return sum; // M과 sum 같으면 최댓값 -> 리턴
                    if (result<sum && sum<M) result = sum;
                }
            }
        }
        return result;
    }
}