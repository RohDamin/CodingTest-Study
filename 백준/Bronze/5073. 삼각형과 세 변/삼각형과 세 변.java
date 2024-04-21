import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 00 && c == 0) break;

            if (a>=(b+c) || b>=(a+c) || c>=(a+b)) {
                sb.append("Invalid").append("\n");
            } else if (a==b && b==c) {
                sb.append("Equilateral").append("\n");
            } else if (a==b || a==c || b==c) {
                sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }
        }
        System.out.println(sb);
    }
}