import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int c1 = a1*b2 + b1*a2;
        int c2 = a2*b2;

        int gcdNum = gcd(c1, c2);

        System.out.print(c1/gcdNum + " " + c2/gcdNum);

        bw.flush();
        bw.close();
        br.close();

    }

    static int gcd (int a, int b) {
        int r;

        while (b != 0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}

