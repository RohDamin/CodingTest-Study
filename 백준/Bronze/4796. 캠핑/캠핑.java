// Greedy Algorithm
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "";
        int i = 0;
        while (true) {
            s = br.readLine();
            if (s.equals("0 0 0")) break;

            StringTokenizer st = new StringTokenizer(s, " ");
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int result = l*(v/p) + Math.min(l, v%p);
            
            i++;
            System.out.printf("Case %d: %d\n", i, result);

        }

        bw.flush();
        bw.close();
        br.close();
    }
}

