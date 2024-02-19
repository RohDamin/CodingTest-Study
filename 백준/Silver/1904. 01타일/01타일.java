// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
    public static int d[] = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        d[0] = 0;
        d[1] = 1; // 1
        d[2] = 2; // 00, 11

        for (int i = 3; i<d.length; i++) {
            d[i] = -1;
        }
        System.out.print(tile(N));
    }
    public static int tile (int n) {
        if(d[n] == -1) {
            d[n] = (tile(n-1) + tile(n-2)) % 15746;
        }
        return d[n];
    }
}
