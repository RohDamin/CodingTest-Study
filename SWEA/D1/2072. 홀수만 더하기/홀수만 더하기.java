import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i=0; i<10; i++) {
                int v = Integer.parseInt(st.nextToken());
                if (v%2 == 1) sum+=v;
            }
            sb.append("#").append(t+1).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}