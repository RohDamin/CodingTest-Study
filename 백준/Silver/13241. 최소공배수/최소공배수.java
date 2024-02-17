import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        // 1. 최대공약수 구하기
        // 2. 최대공약수 이용해서 최소공배수 구하기

        System.out.println(lcm(n, m));

        bw.flush();
        bw.close();
        br.close();

    }

    static long gcd (long a, long b) {
        long r;

        while (b != 0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    static long lcm (long a, long b) {
        return ((a*b)/gcd(a, b));
    }
}

