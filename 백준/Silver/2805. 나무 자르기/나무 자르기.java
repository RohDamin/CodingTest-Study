// Binary Search

import java.io.*;
import java.util.*;

public class Main {
    public static int[] tree, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int maxH = 0;

        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            maxH = maxH <= tree[i] ? tree[i] : maxH;
        }

        int min = 0;
        int max = maxH;
        while (min<max) {
            int mid = (min+max)/2;
            long sum = 0;
            for (int treeH : tree) {
                if (treeH - mid > 0) sum += (treeH-mid);
            }
            if (sum<M) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}