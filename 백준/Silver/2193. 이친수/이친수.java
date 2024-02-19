import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long d[] = new long[N+1];
        d[0] = 0;
        d[1] = 1;

        for (int i = 2;i<=N; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.print(d[N]);
    }
}