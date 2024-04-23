import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] fruitArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            fruitArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(fruitArr);

        for(int i=0; i<N; i++) {
            if (fruitArr[i]<=L) L++;
        }

        System.out.println(L);
    }
}