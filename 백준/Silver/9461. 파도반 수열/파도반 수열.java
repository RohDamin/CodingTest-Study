// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
    public static int d[];
    public static long len[] = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i<N; i++) {
            int k = Integer.parseInt(br.readLine());
            long len[] = new long[k+1];

            len[0] = 0;
            len[1] = 1;

            if (k>1) {
                len[2] = 1;
                for (int j =3; j<=k; j++) {
                    len[j] = len[j-2] + len[j-3];
                }
            }
            System.out.println(len[k]);

        }

    }
}
