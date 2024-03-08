import java.io.*;
import java.util.*;

public class Main {
    static int M, bit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        bit = 0;

        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x;

            switch (op) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    // 원소에 해당하는 bit만 켜야 하기 때문에 OR 연산 사용
                    bit |= (1 << (x-1)); // x번째 비트를 1로 변경
                    break;

                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    bit &= ~(1 << (x-1)); // x번째 비트를 0으로 변경
                    break;

                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append((bit & (1 << (x-1))) != 0 ? "1\n" : "0\n" );
                    break;

                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    bit ^= (1 << (x-1)); // x가 있으면 제거, 없으면 추가
                    break;

                case "all":
                    bit |= (~0); // 모든 비트를 1로 변경
                    break;

                case "empty":
                    bit &= 0; // 모든 비트를 0으로 변경
                    break;
            }
        }
        System.out.println(sb);
    }
}