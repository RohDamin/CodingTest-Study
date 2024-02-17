import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        int dis = Integer.MAX_VALUE;

        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (i == 0){
                continue;
            } else if (i == 1) {
                dis = arr[i]-arr[i-1];
            } else {
                dis = gcd(dis, arr[i]-arr[i-1]);
            }
        }

        int count = ((arr[arr.length-1] - arr[0]) / dis + 1 ) - arr.length;
        System.out.print(count);

        bw.flush();
        bw.close();
        br.close();

    }

    static int gcd(int a, int b) {
        int r;
        while (b!=0){
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}

