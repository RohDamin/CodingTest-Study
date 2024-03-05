/*
백트래킹(backtracking)
- 가능한 모든 조합을 다 시도하는 것
*/
import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] list;
    static char[] code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<C; i++) {
            list[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(list);

        backtrack(0, 0);
    }

    static void backtrack(int x, int idx) {
        if (idx == L) {
            if (isValid()) System.out.println(code);
            return;
        }

        for (int i = x; i<C; i++) {
            code[idx] = list[i];
            backtrack(i+1, idx+1);
        }
    }
    static boolean isValid() {
        int c = 0; // 자음
        int v = 0; // 모음

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') v++;
            else c++;
        }

        return c >= 2 && v >= 1; // 조건 만족하면 true, 만족하지 않으면 false 출력
    }
}